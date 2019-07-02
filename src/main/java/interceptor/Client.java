package interceptor;

public class Client {

	public static void main(String[] args) {

//		Interceptor interceptor = new Interceptor() {
//			public Object intercept(Invocation invocation) throws Throwable {
//				System.out.println("Go Go Go!!!");
//				return invocation.proceed();
//			}
//		};
		
		Interceptor interceptor = new InterceptorImpl();

		Target target = new TargetImpl();
		// 被代理之后
//		target = (Target) TargetProxy.bind(target, interceptor);
//		target.execute1();
//		target.execute2();
		
		target = (Target)interceptor.register(target);
		target.execute1();
		
	}
}
