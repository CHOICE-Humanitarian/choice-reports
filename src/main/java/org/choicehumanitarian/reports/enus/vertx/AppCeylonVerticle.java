package org.choicehumanitarian.reports.enus.vertx;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Callable;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Verticle;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class AppCeylonVerticle extends AbstractVerticle {

	private final AppCeylonVerticleFactory.Module module;
	private Verticle verticle;

	public AppCeylonVerticle(AppCeylonVerticleFactory.Module module) {
		this.module = module;
	}

	@Override
	public void start(Promise<Void> startPromise) throws Exception {
		ClassLoader loader = module.runner.getModuleClassLoader();
		Method introspector = loader.loadClass("io.vertx.ceylon.core.impl.resolveVerticles_")
				.getDeclaredMethod("resolveVerticles", String.class, String.class);
		Map<String, Callable<?>> moduleFactories = (Map<String, Callable<?>>) introspector.invoke(null, module.name,
				null);

		Callable<?> factory = moduleFactories.values().iterator().next();
		verticle = (Verticle) factory.call();
		verticle.init(vertx, context);
		verticle.start(startPromise);
	}

	@Override
	public void stop(Promise<Void> stopPromise) throws Exception {
		try {
			verticle.stop(stopPromise);
		} finally {
			module.removeInstance();
		}
	}
}
