package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadLock {

	public static void createBusyThread() {
		Thread thread =new Thread(new Runnable() {
			@Override
			public void run() {
				while(true)
					;
			}
		}, "testBusyThread");		
		thread.start();
	}
	
	public static void creatLockThread(final Object lock) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock) {
					try{
						lock.wait();
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}, "testLockThread");		
		thread.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createBusyThread();
		try {
			br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object obj = new Object();
		creatLockThread(obj);
	}
}
