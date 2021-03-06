package concurrency.chapter03;

public class DoubleCheckedLocking {
	private static Instance instance;

	public static Instance getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedLocking.class) {
				if (instance == null)
					instance = new Instance();
			}
		}
		return instance;
	}

	static class Instance {
	}
}
