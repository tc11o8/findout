package question.timerIssue;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerIssue2 {

	public static void main(String[] args) {

		// 如果TimerTask抛出RuntimeException，Timer会停止所有任务的运行
		final TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				throw new RuntimeException();
			}
		};

		final TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				System.out.println("task2 invoked!");
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(task1, 100);
		timer.scheduleAtFixedRate(task2, new Date(), 1000);
		
		
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		pool.schedule(task1, 100, TimeUnit.MILLISECONDS);
		pool.scheduleAtFixedRate(task2, 0, 1000, TimeUnit.MILLISECONDS);
	}

}
