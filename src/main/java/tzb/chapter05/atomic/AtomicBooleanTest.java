package tzb.chapter05.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * ���н��˵��������һ��������ҳɹ��ˣ�˵��ֻ��һ���̳߳��Խ�booleanֵ�޸ĳɹ�������Ķ�δ�ɹ����ﵽ���Ч��
 * @author zhongyin.xy
 *
 */
public class AtomicBooleanTest {

	/**
	 * ��Ҫ������
	 * @see AtomicBoolean#compareAndSet(boolean, boolean)  ��һ������Ϊԭʼֵ���ڶ�������ΪҪ�޸ĵ���ֵ�����޸ĳɹ��򷵻�true�����򷵻�false
	 * @see AtomicBoolean#getAndSet(boolean)   ���������µ�booleanֵ��ֱ���ɹ�Ϊֹ����������ǰ�����
	 */
	public final static AtomicBoolean TEST_BOOLEAN = new AtomicBoolean();
	
	public static void main(String []args) {
		for(int i = 0 ; i < 10 ; i++) {
			new Thread() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(TEST_BOOLEAN.compareAndSet(false, true)) {
						System.out.println("�ҳɹ��ˣ�");
					}
				}
			}.start();
		}
	}
	
} 
