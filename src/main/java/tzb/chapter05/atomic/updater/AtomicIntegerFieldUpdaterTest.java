package tzb.chapter05.atomic.updater;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

	static class A {
		volatile int intValue = 100;
	}
	
	/**
	 * ����ֱ�ӷ��ʶ�Ӧ�ı����������޸ĺʹ���
	 * ������Ҫ�ڿɷ��ʵ������ڣ������private�������default�����Լ��Ǹ������protected���޷����ʵ�
	 * ��η��ʶ�������static���͵ı�������Ϊ�ڼ������Ե�ƫ������ʱ���޷����㣩��Ҳ������final���͵ı�������Ϊ���޷��޸ģ�����������ͨ�ĳ�Ա����
	 * 
	 * ������˵���Ϻ�AtomicInteger����һ�£�Ψһ������ǵ�һ��������Ҫ�����������ã�
	 * @see AtomicIntegerFieldUpdater#addAndGet(Object, int)
	 * @see AtomicIntegerFieldUpdater#compareAndSet(Object, int, int)
	 * @see AtomicIntegerFieldUpdater#decrementAndGet(Object)
	 * @see AtomicIntegerFieldUpdater#incrementAndGet(Object)
	 * 
	 * @see AtomicIntegerFieldUpdater#getAndAdd(Object, int)
	 * @see AtomicIntegerFieldUpdater#getAndDecrement(Object)
	 * @see AtomicIntegerFieldUpdater#getAndIncrement(Object)
	 * @see AtomicIntegerFieldUpdater#getAndSet(Object, int)
	 */
	public final static AtomicIntegerFieldUpdater <A>ATOMIC_INTEGER_UPDATER = AtomicIntegerFieldUpdater.newUpdater(A.class, "intValue");
	
	public static void main(String []args) {
		final A a = new A();
		for(int i = 0 ; i < 100 ; i++) {
			final int num = i;
			new Thread() {
				public void run() {
					if(ATOMIC_INTEGER_UPDATER.compareAndSet(a, 100, 120)) {
						System.out.println("�����̣߳�" + num + " �ҶԶ�Ӧ��ֵ�����޸ģ�");
					}
				}
			}.start();
		}
	}
}
