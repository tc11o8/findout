package question;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载与 instance of 关键字演示
 * @author Administrator
 *
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		ClassLoader myLoader = new ClassLoader() {
			@Override			
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				try {
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
					InputStream isInputStream=getClass().getResourceAsStream(fileName);
					if(isInputStream==null){
						return super.loadClass(name);
					}
					byte[] b=new byte[isInputStream.available()];
					isInputStream.read(b);
					return defineClass(name, b, 0, b.length);
					
				} catch (IOException e) {
					throw new ClassNotFoundException();
				}
			}
		};
		
		Object object = myLoader.loadClass("question.CalendarDemo").newInstance();
		
		System.out.println(object.getClass());
		System.out.println(object instanceof question.CalendarDemo);
	}

}
