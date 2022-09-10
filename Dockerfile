FROM registry.access.redhat.com/ubi8/openjdk-11

MAINTAINER Christopher Tate <computate@computate.org>

COPY . choice-reports
USER root

RUN mvn clean install -DskipTests
RUN cp /home/jboss/choice-reports/target/*.jar /home/jboss/app.jar
CMD java $JAVA_OPTS -cp .:* org.choicehumanitarian.reports.enus.vertx.MainVerticle

