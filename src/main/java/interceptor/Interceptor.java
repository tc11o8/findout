package interceptor;

public interface Interceptor {

//	public void intercept();
	
	public Object intercept(Invocation invocation)throws Throwable ;
	
	public Object register(Object target);
	
}
