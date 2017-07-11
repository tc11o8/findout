package tzb.chapter05.atomic.reference;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ������⣺
 * ���ABA���⣬ͨ��һ�����úͰ汾��Ϊ����ABA���⣬
 * ��һ�������A���B���ٴ�B���A����ʱ�������У�ĳ���̷߳��ֶ�����A����ô��ʱ�ͻ�Աȳɹ�
 * Ϊ�˽��������⣬AtomicStampedʹ���˰汾��������������
 * ABA�����ģ����ο�ģ����룺
 * @author zhongyin.xy
 *
 */
public class AtomicStampedReferenceTest {
	
	/**
	 * ����ķ�����
	 * @see AtomicStampedReference#compareAndSet(Object, Object, int, int) �Ա��޸�
	 * @see AtomicStampedReference#attemptStamp(Object, int) ���ھ���ж��Ƿ�һ�£�����true|false
	 * @see AtomicStampedReference#getReference() ��������
	 * @see AtomicStampedReference#getStamp() ���ذ汾
	 * @see AtomicStampedReference#get(int[]) ����һ�����飬���������0��Ԫ��Ϊ�汾��
	 */
	public final static AtomicStampedReference <String>ATOMIC_REFERENCE = new AtomicStampedReference<String>("abc" , 0);
	
	private final static Random RANDOM_OBJECT = new Random();

	public static void main(String []args) throws InterruptedException {
		final CountDownLatch startCountDownLatch = new CountDownLatch(1);
		Thread []threads = new Thread[20];
		for(int i = 0 ; i < 20 ; i++) {
			final int num = i;
			threads[i] = new Thread() {
				public void run() {
					String oldValue = ATOMIC_REFERENCE.getReference();
					int stamp = ATOMIC_REFERENCE.getStamp();
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
					if(ATOMIC_REFERENCE.compareAndSet(oldValue , oldValue + num , stamp , stamp + 1)) {
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
				int stamp = ATOMIC_REFERENCE.getStamp();
				while(!ATOMIC_REFERENCE.compareAndSet(ATOMIC_REFERENCE.getReference(), "abc" , stamp , stamp + 1)) {
					stamp = ATOMIC_REFERENCE.getStamp();
				}
				System.out.println("�Ѿ���Ϊԭʼֵ��");
			}
		}.start();
	}
}
