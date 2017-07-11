package springAop;

public class ProxyTest {

	public static void main(String[] args) {

		cglibTest();
	}

	public static void cglibTest() {
		Person p = new Person("lg");
		p = CglibProxy.createProxy(p);
		p.sayHello();

		System.out.println("-------------------------------");

		Animals animals = new Animals();
		animals = CglibProxy.createProxy(animals);
		animals.sayHello();
	}

	public static void jdkProxyTest() {
		Say say1 = new Person("lg");
		say1 = (Say) JDKDynamicProxy.createProxy(say1);
		say1.sayHello();

		System.out.println("-------------------------------");

		Say say2 = new Animals();
		say2 = (Say) JDKDynamicProxy.createProxy(say2);
		say2.sayHello();
	}
}