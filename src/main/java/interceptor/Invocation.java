package interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * target,method,args再进行一次封装成 Invocation类
 */
public class Invocation {
	private Object target;
	private Method method;
	private Object[] args;

	public Invocation(Object target, Method method, Object[] args) {
		this.target = target;
		this.method = method;
		this.args = args;
	}

	// 成员变量尽可能在自己的内部操作，而不是 Intereptor 获取自己的成员变量来操作他们
	public Object proceed() throws InvocationTargetException, IllegalAccessException {
		return method.invoke(target, args);
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
}
