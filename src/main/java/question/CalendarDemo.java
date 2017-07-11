package question;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Calendar cal=Calendar.getInstance();
		// cal.set(Calendar.DAY_OF_WEEK, 2);
		// Date monDateNow = cal.getTime();
		//
		// cal.add(Calendar.WEEK_OF_MONTH, -1);
		// cal.set(Calendar.DAY_OF_WEEK, 2);
		// Date monDate = cal.getTime();
		//
		// System.out.println(monDateNow);
		// System.out.println(monDate);

		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		//cal.setTime();
		
		
		//Date sDate = cal.getTime();
		cal.add(Calendar.DATE, 3);
		//cal.set(Calendar.nu)
		cal.set(Calendar.HOUR_OF_DAY, 1);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		 
		
		
		Date endTime = cal.getTime();
		
		if((new Date()).after(endTime)){
			System.out.println("yes");
		}
		
		System.out.println(cal.getTime().getTime());
		
		System.out.println((new Date()).getTime());
		
		String dateString = "2012-12-06";  
		  
		try {
			Calendar cal2 = Calendar.getInstance();
			Date date = sdf.parse(dateString);
			cal2.setTime(date);
			cal2.add(Calendar.DATE, 3);
			
			System.out.println(cal2.getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		    
		    
		//Date eDate = cal.getTime();

		//System.out.println(eDate);

		// cal.set(Calendar.DAY_OF_WEEK, 1);
		// System.out.println("上周日为："+sdf.format(cal.getTime()));
		//
		// long minutes = (long)(eDate.getTime()-sDate.getTime())/(1000*60);
		// System.out.println(minutes);
	}

}
