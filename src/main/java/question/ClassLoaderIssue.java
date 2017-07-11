package question;

public class ClassLoaderIssue {

	public static void main(String[] args) {

		// System.out.println(FillHeap.class.getClassLoader().getClass().getName());
		// // 得到我们自定义类的字节码，得到此字节码的类加载器,得到类加载器的字节码
		// System.out.println(FillHeap.class.getClassLoader().getClass());
		//
		// // 得到系统类的字节码，得到此字节码的类加载器
		// System.out.println(System.class.getClassLoader());
		// // 得到系统类的字节码，得到此字节码的类加载器,得到类加载器的字节码,得到字节码的名字
		// System.out.println(System.class.getClassLoader().getClass().getName());

		// ClassLoader cl = FillHeap.class.getClassLoader();
		// while (cl != null) {
		// System.out.println(cl.getClass().getName());
		// // cl本来就是类加载器了，下面这样的写法是得到父加载器的父加载器多跳了1级
		// cl = cl.getParent().getClass().getClassLoader();
		// }
		// // 打印第一个类加载器
		// System.out.println(cl);
		// System.out.println("------------正确输出-------------");
		// cl = FillHeap.class.getClassLoader();
		// while (cl != null) {
		// System.out.println(cl.getClass().getName());
		// cl = cl.getParent();
		// }
		// // 打印第一个类加载器
		// System.out.println(cl);

		//jre\lib\ext
//		ClassLoader cl = ClassLoaderIssue.class.getClassLoader();
//		System.out.println("------------正确输出-------------");
//		cl = ClassLoaderIssue.class.getClassLoader();
//		while (cl != null) {
//			System.out.println(cl.getClass().getName());
//			cl = cl.getParent();
//		}
//		// 打印第一个类加载器
//		System.out.println(cl);
		
		
		Thread a = Thread.currentThread();
        System.out.println(a.getContextClassLoader().getClass().getName());
        //这里不写.getClass().getName())是因为null没有字节码,写了程序报空指针异常。
        a.setContextClassLoader(System.class.getClassLoader());
        System.out.println(a.getContextClassLoader());
	}

}
