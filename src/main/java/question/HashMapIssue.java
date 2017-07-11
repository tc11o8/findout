package question;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class HashMapIssue {

	private final Map<Integer, Integer> map = new HashMap<>();
	// private final ExecutorService exec;

	public void doPut() {
		Runnable run1 = new Runnable() {

			@Override
			public void run() {
				// map

			}
		};
	}

	public static void main(String[] args) {

	}

}
