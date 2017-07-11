package concurrency.chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadState {

	private static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		new Thread(new TimeWaiting(), "TimeWaitingThread").start();
		new Thread(new Waiting(), "WaitingThread").start();
		new Thread(new Blocked(), "BlockedThread-1").start();
		new Thread(new Blocked(), "BlockedThread-2").start();
		new Thread(new Sync(), "SyncThread-1").start();
		new Thread(new Sync(), "SyncThread-2").start();
	}

	static class TimeWaiting implements Runnable {
		@Override
		public void run() {
			while (true) {
				SleepUtils.second(100);
			}
		}
	}

	static class Waiting implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	static class Blocked implements Runnable {
		public void run() {
			synchronized (Blocked.class) {
				while (true) {
					SleepUtils.second(100);
				}
			}
		}
	}

	static class Sync implements Runnable {

		@Override
		public void run() {
			lock.lock();
			try {
				SleepUtils.second(100);
			} finally {
				lock.unlock();
			}

		}

	}
}