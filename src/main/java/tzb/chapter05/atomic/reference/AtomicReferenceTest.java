package tzb.chapter05.atomic.reference;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ����˵��ΪʲôҪ�����õ�Atomic��
 * 		��Ϊ�����ڸ�ֵ��˲��Ҳ����ڶ�д�Ĳ����������ڴ�����������int��long��������ݵı仯
 *      һ����˵������Ϊȫ����Ϣ��������٣�����Ҳ�����в�����������ڣ���Ȼ��Щ�����౾��������Щ���⣬��������ǵ���������滻���ͻ�����Щ������
 *      ���磺�ڴ��ж���������������л�д�������л���˲���Լ������̻߳�ȡ����˲����Ҫ�õ���׼ȷ����Ϣ��ʹ���л�ʱ����Ч�ġ�
 * 
 * ���ӽ��˵����100���߳�������������룬ֻ��һ���߳��ܻ�ȡ����Զ�������޸�
 * ����abc2��Ŀ�����Ϊabc����ôÿ���̶߳���õ�ִ�У���Ϊ���ܶԲ��ɹ���abc�����ڳ�������Ψһ��ַ
 * ��Ŀ���Ϊnew String("abc")Ҳ��ֻ��һ���޸ĳɹ���˵���Ƚϵ������ö�������
 * @author zhongyin.xy
 *
 */
public class AtomicReferenceTest {

	/**
	 * ��ط����б�
	 * @see AtomicReference#compareAndSet(Object, Object) �Ա�����ֵ������1��ԭʼֵ������2���޸�Ŀ������
	 * @see AtomicReference#getAndSet(Object) �����õ�Ŀ���޸�Ϊ���õĲ���ֱ���޸ĳɹ�Ϊֹ�������޸�ǰ������
	 */
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
						Thread.sleep(RANDOM_OBJECT.nextInt() & 1000);
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
		for(Thread thread : threads) {
			thread.join();
		}
		System.out.println("���ս��Ϊ��" + ATOMIC_REFERENCE.get());
	}
}
