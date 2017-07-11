package question.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;


/**
 * 动态代理实现两种方式  JDK动态代理        CGLib动态代理 ASM
 * @author yxx
 * */
public class Application {
    public static void main(String[] args) {
    	  
    	//JDK动态代理
        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(
                userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(), userService.getClass()
                        .getInterfaces(), invocationHandler);
        System.out.println(userServiceProxy.getName(1));
        System.out.println(userServiceProxy.getAge(1));
        
        
        
    	//Cglib实现动态代理
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService o = (UserService) enhancer.create();
        System.out.println(o.getName(1));
        System.out.println(o.getAge(1));
        
    }
}