package tzb.chapter05.tools;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	
	private final static int GROUP_SIZE = 5;
	
	private final static Random random = new Random();
	
	public static void main(String []args) throws InterruptedException {
		processOneGroup("����1");
		processOneGroup("����2");
	}
	
	private static void processOneGroup(final String groupName) throws InterruptedException {
		final CountDownLatch preCountDown = new CountDownLatch(GROUP_SIZE);//�ȴ����ж�Ա׼������
		final CountDownLatch startCountDown = new CountDownLatch(1);
		final CountDownLatch endCountDown = new CountDownLatch(GROUP_SIZE);
		System.out.println("==========================>\n���飺" + groupName + "����ʼ��");
		for(int i = 0 ; i < GROUP_SIZE ; i++) {
			new Thread(String.valueOf(i)) {
				public void run() {
					preCountDown.countDown();//���׼������
					System.out.println("�����߳��飺��" + groupName + "��,�ڣ�" + this.getName() + " ���߳�,���Ѿ�׼��������");
					try {
						startCountDown.await();//�ȴ���з�����ʼָ�start_count_down.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(Math.abs(random.nextInt()) % 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("�����߳��飺��" + groupName + "��,�ڣ�" + this.getName() + " ���߳�,����ִ����ɣ�");
					endCountDown.countDown();
				}
			}.start();
		}
		preCountDown.await();//�ȴ����ж�Ա��λ
		System.out.println("���͸�λ��Ԥ����");
		startCountDown.countDown();//��ʼ����
		try {
			endCountDown.await();//�ȴ����������������
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(groupName + "�������");
	}
}
