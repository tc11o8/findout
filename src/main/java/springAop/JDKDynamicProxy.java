package springAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy {

	public static Object createProxy(final Object target) {
		return Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (method.getName().equals("sayHello")) {
							doBefore();
							try {
								method.invoke(target, args);
							} catch (Exception e) {
								doThrowing();
							}
							doAfter();
						}
						return null;
					}

				});
	}

	private static void doThrowing() {
		System.out.println("AOP say throw a exception");
	}

	private static void doBefore() {
		System.out.println("AOP before say");
	}

	private static void doAfter() {
		System.out.println("AOP after say");
	}

}