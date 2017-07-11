package tzb.chapter05.atomic.reference;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ABA����ģ�⣬�̲߳����У�����ABA���⣬���������ʹ��|AtomicMarkableReference
 * ��ο���Ӧ�����ӣ�AtomicStampedReferenceTest��AtomicMarkableReferenceTest
 * @author zhongyin.xy
 *
 */
public class AtomicReferenceABATest {
	
	public final static AtomicReference <String>ATOMIC_REFERENCE = new AtomicReference<String>("abc");
	
	private final static Random RANDOM_OBJECT = new Random();

	public static void main(String []args) throws InterruptedException {
		final CountDownLatch startCountDownLatch = new CountDownLatch(1);
		Thread []threads = new Thread[20];
		for(int i = 0 ; i < 20 ; i++) {
			final int num = i;
			threads[i] = new Thread() {
				public void run() {
					String oldValue = ATOMIC_REFERENCE.get();
					try {
						startCountDownLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(RANDOM_OBJECT.nextInt() & 500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(ATOMIC_REFERENCE.compareAndSet(oldValue , oldValue + num)) {
						System.out.println("�����̣߳�" + num + ",�һ����������˶����޸ģ�");
					}
				}
			};
			threads[i].start();
		}
		Thread.sleep(200);
		startCountDownLatch.countDown();
		new Thread() {
			public void run() {
				try {
					Thread.sleep(RANDOM_OBJECT.nextInt() & 200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while(!ATOMIC_REFERENCE.compareAndSet(ATOMIC_REFERENCE.get(), "abc"));
				System.out.println("�Ѿ���Ϊԭʼֵ��");
			}
		}.start();
	}
}
