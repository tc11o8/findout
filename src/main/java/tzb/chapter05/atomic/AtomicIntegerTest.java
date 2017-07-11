package tzb.chapter05.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ���˵����������߳�ͬʱ��ͬһ���������е��Ӳ�����ÿ���̼߳�1�����ս��Ϊ��ʼֵ+�̸߳���Ϊ�ɹ�
 * @author zhongyin.xy
 *
 */
public class AtomicIntegerTest {

	/**
	 * ����ķ����б�
	 * @see AtomicInteger#get()             ֱ�ӷ���ֵ
	 * @see AtomicInteger#getAndAdd(int)    ����ָ������ݣ����ر仯ǰ�����
	 * @see AtomicInteger#getAndDecrement() ����1�����ؼ���ǰ�����
	 * @see AtomicInteger#getAndIncrement() ����1����������ǰ�����
	 * @see AtomicInteger#getAndSet(int)    ����ָ������ݣ���������ǰ�����
	 * 
	 * @see AtomicInteger#addAndGet(int)    ����ָ������ݺ󷵻����Ӻ�����
	 * @see AtomicInteger#decrementAndGet() ����1�����ؼ��ٺ��ֵ
	 * @see AtomicInteger#incrementAndGet() ����1���������Ӻ��ֵ
	 * @see AtomicInteger#lazySet(int)      ������getʱ�Ż�set
	 * 
	 * @see AtomicInteger#compareAndSet(int, int) ����������Աȣ������ӳɹ��򷵻�true���򷵻�false
	 */
	public final static AtomicInteger TEST_INTEGER = new AtomicInteger(1);
	
	private static int index = 1;
	
	public static void main(String []args) throws InterruptedException {
		final CountDownLatch start_count_down = new CountDownLatch(1);
		final Thread []threads = new Thread[10];
		 for(int i = 0 ; i < 10 ; i++) {
			 threads[i] = new Thread() {
				 public void run() {
					try {
						start_count_down.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for(int j = 0 ; j < 100 ; j++) {
						index++;
						TEST_INTEGER.incrementAndGet();
					}
				 }
			 };
			 threads[i].start();
		 }
		 Thread.sleep(500);
		 start_count_down.countDown();
		 for(Thread t : threads) {
			 t.join();
		 }
		 System.out.println("�������н��" + TEST_INTEGER.get());
		 System.out.println("�������н��" + index);
	}
}
