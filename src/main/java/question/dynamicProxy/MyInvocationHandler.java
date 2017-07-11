package question.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Object target;

	MyInvocationHandler() {
		super();
	}

	MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("getName".equals(method.getName())) {
			System.out.println("++++++before getName " + method.getName() + "++++++");
			Object result = method.invoke(target, args);
			System.out.println("++++++after " + method.getName() + "++++++");
			return result;
		} else if ("getAge".equals(method.getName())) {
			System.out.println("++++++before getAge " + method.getName() + "++++++");
			Object result = method.invoke(target, args);
			System.out.println("++++++after " + method.getName() + "++++++");
			return result;
		} else {
			Object result = method.invoke(target, args);
			return result;
		}
	}
}
