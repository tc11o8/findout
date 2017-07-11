package question;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class main {

	public static void main(String[] args) {
		
		int r = 10;
		int t = r>>>2;
		
		System.out.println(Integer.toBinaryString(r));
		System.out.println(Integer.toBinaryString(t));
		
		
		
		
		String[] listStrings = {};
		
		System.out.println(listStrings.getClass()); 
		System.out.println(listStrings.length); 
		System.out.println(listStrings==null); 
		
		List<String> list = new ArrayList<String>(2);
		list.add("aa");
		list.add("bb");
		String[] array = new String[list.size()];
		array = list.toArray(array);
		
		String startDate = "2016-01-23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    try {
			Date date = sdf.parse(startDate);
//			if(date.after(sDate)){
//				
//			}else{
//				
//			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
		//dead lock demo
//		Runnable scrpit = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread()+"start");
//				DeadLoopClass dlc = new DeadLoopClass();
//				System.out.println(Thread.currentThread()+" run over");
//			}
//		};
//		
//		Thread thread1 = new Thread(scrpit);
//		Thread thread2 = new Thread(scrpit);
//		thread1.start();
//		thread2.start();
	}

}
