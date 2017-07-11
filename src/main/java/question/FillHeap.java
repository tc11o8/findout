package question;

import java.util.ArrayList;
import java.util.List;

public class FillHeap {

	static class OOMObject{
		public byte[] placeholder = new byte[64*1024];
		
	}
	
	public static void fillHeap(int num) throws InterruptedException{
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		for(int i=0;i<num;i++){
			Thread.sleep(500);
			list.add(new OOMObject());
		}	
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			fillHeap(1000);
			System.gc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("error");
		}
	}

}
