package tzb.chapter05.atomic.updater;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterTest {
	
	static class A {
		volatile String stringValue = "abc";
	}

	/**
	 * ʹ�÷�ʽ��AtomicReferenceһ�£�ʹ�÷�Χ��AtomicIntegerFieldUpdaterһ��
	 * 
	 */
	AtomicReferenceFieldUpdater <A , String>ATOMIC_REFERENCE_FIELD_UPDATER = AtomicReferenceFieldUpdater.newUpdater(A.class, String.class, "stringValue");
}
