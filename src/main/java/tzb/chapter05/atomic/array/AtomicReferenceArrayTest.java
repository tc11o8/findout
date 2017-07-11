package tzb.chapter05.atomic.array;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayTest {

	/**
	 * �����б?
	 * @see AtomicReferenceArray#compareAndSet(int, Object, Object) ����1�������±ꣻ����2���޸�ԭʼֵ�Աȣ�����3���޸�Ŀ��ֵ �޸ĳɹ�����true�����򷵻�false
	 * 
	 * @see AtomicReferenceArray#getAndSet(int, Object) ����1�������±꣬����2���޸ĵ�Ŀ�꣬�޸ĳɹ�Ϊֹ�������޸�ǰ�����
	 * 
	 */
	public final static AtomicReferenceArray<String> ATOMIC_REFERENCE_ARRAY = new AtomicReferenceArray<String>(
			new String [] {"a" , "b" , "c"}
	);
}
