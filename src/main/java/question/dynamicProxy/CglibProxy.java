package question.dynamicProxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("++++++before " + method.getName() + "++++++");
		System.out.println(method.getName());
		Object o1 = methodProxy.invokeSuper(o, args);
		System.out.println("++++++after " + method.getName() + "++++++");
		return o1;
	}
	
	
}