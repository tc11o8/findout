package interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {

	private Object target;

	// 拦截器
	private Interceptor interceptor;

	private TargetProxy(Object target, Interceptor interceptor) {
		this.target = target;
		this.interceptor = interceptor;
	}

	// 通过传入客户端封装好 interceptor 的方式为 target 生成代理对象，使得客户端可以灵活使用不同的拦截器逻辑
	public static Object bind(Object target, Interceptor interceptor) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new TargetProxy(target, interceptor));
	}

	// 代理对象生成目标对象
	// public static Object bind(Object target) {
	// return Proxy.newProxyInstance(target.getClass().getClassLoader(),
	// target.getClass().getInterfaces(),
	// new TargetProxy(target));
	// }

	//

	/*
	 * public Object invoke(Object proxy, Method method, Object[] args) throws
	 * Throwable {
	 * 
	 * //客户端实现自定义的拦截逻辑 interceptor.intercept(); //
	 * 拦截逻辑在代理对象中写死了，这样到这客户端没有灵活的设置来拦截其逻辑 // System.out.println("Begin"); return
	 * method.invoke(target, args); }
	 */

	// public Object invoke(Object proxy, Method method, Object[] args) throws
	// Throwable {
	// return interceptor.intercept(new Invocation(target, method, args));
	// }

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MethodName methodName = this.interceptor.getClass().getAnnotation(MethodName.class);
		if (methodName == null) {
			throw new NullPointerException("xxxx");
		}
		// 如果方法名称和注解标记的方法名称相同，则拦截
		String name = methodName.value();
		if (name.equals(method.getName())) {
			return interceptor.intercept(new Invocation(target, method, args));
		}
		return method.invoke(this.target, args);
	}
}
