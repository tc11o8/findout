package question;

public class ThreadDeadLock implements Runnable {

	int a,b;
	
	public ThreadDeadLock(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void run(){
		synchronized (Integer.valueOf(a)) {
			synchronized (Integer.valueOf(b)) {
				System.out.println(a+b);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=0;i<100;i++){
			new Thread(new ThreadDeadLock(1, 2)).start();
			new Thread(new ThreadDeadLock(2, 1)).start();
		}
	}

}
