package org.choicehumanitarian.reports.enus.search;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * Keyword: classSimpleNameSearchTool
 * 
 * @author ctate
 *
 */
public class SearchTool {

	public static final TimeZone UTC = TimeZone.getTimeZone("UTC");

	/** Default TimeZone for DateMath rounding (UTC) */
	public static final TimeZone DEFAULT_MATH_TZ = UTC;

	/**
	 * Differs by {@link DateTimeFormatter#ISO_INSTANT} in that it's lenient.
	 * 
	 * @see #parseNoMath(String)
	 */
	public static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient()
			.appendInstant().toFormatter(Locale.ROOT);

	/**
	 * A mapping from (uppercased) String labels identifying time units, to the
	 * corresponding {@link ChronoUnit} enum (e.g. "YEARS") used to set/add/roll
	 * that unit of measurement.
	 *
	 * <p>
	 * A single logical unit of time might be represented by multiple labels for
	 * convenience (ie: <code>DATE==DAYS</code>, <code>MILLI==MILLIS</code>)
	 * </p>
	 *
	 * @see Calendar
	 */
	public static final Map<String, ChronoUnit> CALENDAR_UNITS = makeUnitsMap();

	/** @see #CALENDAR_UNITS */
	private static Map<String, ChronoUnit> makeUnitsMap() {

		// NOTE: consciously choosing not to support WEEK at this time,
		// because of complexity in rounding down to the nearest week
		// around a month/year boundary.
		// (Not to mention: it's not clear what people would *expect*)
		//
		// If we consider adding some time of "week" support, then
		// we probably need to change "Locale loc" to default to something
		// from a param via SolrRequestInfo as well.

		Map<String, ChronoUnit> units = new HashMap<>(13);
		units.put("YEAR", ChronoUnit.YEARS);
		units.put("YEARS", ChronoUnit.YEARS);
		units.put("MONTH", ChronoUnit.MONTHS);
		units.put("MONTHS", ChronoUnit.MONTHS);
		units.put("DAY", ChronoUnit.DAYS);
		units.put("DAYS", ChronoUnit.DAYS);
		units.put("DATE", ChronoUnit.DAYS);
		units.put("HOUR", ChronoUnit.HOURS);
		units.put("HOURS", ChronoUnit.HOURS);
		units.put("MINUTE", ChronoUnit.MINUTES);
		units.put("MINUTES", ChronoUnit.MINUTES);
		units.put("SECOND", ChronoUnit.SECONDS);
		units.put("SECONDS", ChronoUnit.SECONDS);
		units.put("MILLI", ChronoUnit.MILLIS);
		units.put("MILLIS", ChronoUnit.MILLIS);
		units.put("MILLISECOND", ChronoUnit.MILLIS);
		units.put("MILLISECONDS", ChronoUnit.MILLIS);

		// NOTE: Maybe eventually support NANOS

		return units;
	}

	/**
	 * Returns a modified time by "adding" the specified value of units
	 *
	 * @exception IllegalArgumentException if unit isn't recognized.
	 * @see #CALENDAR_UNITS
	 */
	private static LocalDateTime add(LocalDateTime t, int val, String unit) {
		ChronoUnit uu = CALENDAR_UNITS.get(unit);
		if (null == uu) {
			throw new IllegalArgumentException("Adding Unit not recognized: " + unit);
		}
		return t.plus(val, uu);
	}

	/**
	 * Returns a modified time by "rounding" down to the specified unit
	 *
	 * @exception IllegalArgumentException if unit isn't recognized.
	 * @see #CALENDAR_UNITS
	 */
	private static LocalDateTime round(LocalDateTime t, String unit) {
		ChronoUnit uu = CALENDAR_UNITS.get(unit);
		if (null == uu) {
			throw new IllegalArgumentException("Rounding Unit not recognized: " + unit);
		}
		// note: OffsetDateTime.truncatedTo does not support >= DAYS units so we handle
		// those
		switch (uu) {
		case YEARS:
			return LocalDateTime.of(LocalDate.of(t.getYear(), 1, 1), LocalTime.MIDNIGHT); // midnight is 00:00:00
		case MONTHS:
			return LocalDateTime.of(LocalDate.of(t.getYear(), t.getMonth(), 1), LocalTime.MIDNIGHT);
		case DAYS:
			return LocalDateTime.of(t.toLocalDate(), LocalTime.MIDNIGHT);
		default:
			assert !uu.isDateBased();// >= DAY
			return t.truncatedTo(uu);
		}
	}

	/**
	 * Parses a String which may be a date (in the standard ISO-8601 format)
	 * followed by an optional math expression. The TimeZone is taken from the
	 * {@code TZ} param retrieved via {@link SolrRequestInfo}, defaulting to UTC.
	 * 
	 * @param now an optional fixed date to use as "NOW". {@link SolrRequestInfo} is
	 *            consulted if unspecified.
	 * @param val the string to parse
	 */
	public static Date parseMath(Date now, String val) {
		return parseMath(now, val, null);
	}

	/**
	 * Parses a String which may be a date (in the standard ISO-8601 format)
	 * followed by an optional math expression.
	 * 
	 * @param now  an optional fixed date to use as "NOW"
	 * @param val  the string to parse
	 * @param zone the timezone to use
	 */
	public static Date parseMath(Date now, String val, TimeZone zone) {
		String math;

		if (val.startsWith("NOW")) {
			math = val.substring("NOW".length());
		} else {
			final int zz = val.indexOf('Z');
			if (zz == -1) {
				throw new RuntimeException("Invalid Date String:'" + val + '\'');
			}
			math = val.substring(zz + 1);
			try {
				now = parseNoMath(val.substring(0, zz + 1));
			} catch (DateTimeParseException e) {
				throw new RuntimeException("Invalid Date in Date Math String:'" + val + '\'', e);
			}
		}

		if (null == math || math.equals("")) {
			return now;
		}

		try {
			return parseMathInner(now, math, zone);
		} catch (ParseException e) {
			throw new RuntimeException("Invalid Date Math String:'" + val + '\'', e);
		}
	}

	/**
	 * Parsing Solr dates <b>without DateMath</b>. This is the standard/pervasive
	 * ISO-8601 UTC format but is configured with some leniency.
	 *
	 * Callers should almost always call {@link #parseMath(Date, String)} instead.
	 *
	 * @throws DateTimeParseException if it can't parse
	 */
	private static Date parseNoMath(String val) {
		// TODO write the equivalent of a Date::from; avoids Instant -> Date
		return new Date(PARSER.parse(val, Instant::from).toEpochMilli());
	}

	/**
	 * Parses a string of commands relative "now" are returns the resulting Date.
	 * 
	 * @exception ParseException positions in ParseExceptions are token positions,
	 *                           not character positions.
	 */
	public static Date parseMathInner(Date now, String math, TimeZone zone) throws ParseException {
		/* check for No-Op */
		if (0 == math.length()) {
			return now;
		}

		ZoneId zoneId = zone.toZoneId();
		// localDateTime is a date and time local to the timezone specified
		LocalDateTime localDateTime = ZonedDateTime.ofInstant(now.toInstant(), zoneId).toLocalDateTime();

		String[] ops = splitter.split(math);
		int pos = 0;
		while (pos < ops.length) {

			if (1 != ops[pos].length()) {
				throw new ParseException("Multi character command found: \"" + ops[pos] + "\"", pos);
			}
			char command = ops[pos++].charAt(0);

			switch (command) {
			case '/':
				if (ops.length < pos + 1) {
					throw new ParseException("Need a unit after command: \"" + command + "\"", pos);
				}
				try {
					localDateTime = round(localDateTime, ops[pos++]);
				} catch (IllegalArgumentException e) {
					throw new ParseException("Unit not recognized: \"" + ops[pos - 1] + "\"", pos - 1);
				}
				break;
			case '+': /* fall through */
			case '-':
				if (ops.length < pos + 2) {
					throw new ParseException("Need a value and unit for command: \"" + command + "\"", pos);
				}
				int val = 0;
				try {
					val = Integer.parseInt(ops[pos++]);
				} catch (NumberFormatException e) {
					throw new ParseException("Not a Number: \"" + ops[pos - 1] + "\"", pos - 1);
				}
				if ('-' == command) {
					val = 0 - val;
				}
				try {
					String unit = ops[pos++];
					localDateTime = add(localDateTime, val, unit);
				} catch (IllegalArgumentException e) {
					throw new ParseException("Unit not recognized: \"" + ops[pos - 1] + "\"", pos - 1);
				}
				break;
			default:
				throw new ParseException("Unrecognized command: \"" + command + "\"", pos - 1);
			}
		}

		return Date.from(ZonedDateTime.of(localDateTime, zoneId).toInstant());
	}

	private static Pattern splitter = Pattern.compile("\\b|(?<=\\d)(?=\\D)");

	/**
	 * See: <a href=
	 * "https://www.google.com/?gws_rd=ssl#q=lucene+query+parser+syntax">Lucene
	 * query parser syntax</a> for more information on Escaping Special Characters
	 */
	// NOTE: its broken to link to any lucene-queryparser.jar docs, not in
	// classpath!!!!!
	public static String escapeQueryChars(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// These characters are part of the query syntax and must be escaped
			if (c == '\\' || c == '+' || c == '-' || c == '!' || c == '(' || c == ')' || c == ':' || c == '^'
					|| c == '[' || c == ']' || c == '\"' || c == '{' || c == '}' || c == '~' || c == '*' || c == '?'
					|| c == '|' || c == '&' || c == ';' || c == '/' || Character.isWhitespace(c)) {
				sb.append('\\');
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
