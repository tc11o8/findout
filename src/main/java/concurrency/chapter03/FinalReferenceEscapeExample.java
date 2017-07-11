package concurrency.chapter03;

public class FinalReferenceEscapeExample {

	final int i;
	static FinalReferenceEscapeExample obj;

	public FinalReferenceEscapeExample() {
		i = 1;
		obj = this;
	}

	public static void writer() {
		new FinalReferenceEscapeExample();
	}

	public static void reader() {
		if (obj != null) {
			int temp = obj.i;
		}
	}
}
