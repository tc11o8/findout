package tzb.chapter05.atomic.reference;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceTest {

	/**
	 * ʹ�÷�ʽ���AtomicStampedReferenceһ��
	 * ����������Ӽ����������Ĺ�ϵ��������ֻ������״̬�������ڽ��ABA�����ʱ��Ҫ�����е�Ŀ��ͨ��ֻ������״̬
	 * ��ΪABA����Ҫ���ǵ���ģ���Ϊȷ����������һ����һ��״̬�����һ��״̬�󣬾Ͳ����ٱ仯������ֻ�Ǹ���Ҫ��ֻ������״̬
	 * һ�����ƣ���ɾ����ʧЧ�Ȳ��ɸ��õ����������AtomicStampedReference��Ӿ��пɶ��ԣ���ΪAtomicStampedReference������һ�����޸ĵİ汾�źͼ�����
	 */
	public final static AtomicMarkableReference <String>ATOMIC_MARKABLE_REFERENCE = new AtomicMarkableReference<String>("abc" , false);
	
	{
		ATOMIC_MARKABLE_REFERENCE.compareAndSet("abc", "abc2", false, true);
	}
}
