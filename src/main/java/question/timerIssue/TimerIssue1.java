package question.timerIssue;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerIssue1 {

	private static long start;

	public static void main(String[] args) {

		//Timer管理延时任务的缺陷
		TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				System.out.println("task1 invoked ! " + (System.currentTimeMillis() - start));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};
		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				System.out.println("task2 invoked ! " + (System.currentTimeMillis() - start));
			}
		};

		
		Timer timer = new Timer();
		start = System.currentTimeMillis();
		timer.schedule(task1, 1000);
		timer.schedule(task2, 3000);

		
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
		start = System.currentTimeMillis();
		newScheduledThreadPool.schedule(task1, 1000, TimeUnit.MILLISECONDS);
		newScheduledThreadPool.schedule(task2, 3000, TimeUnit.MILLISECONDS);
		
	}
}
