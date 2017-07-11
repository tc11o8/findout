package tzb.chapter01;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unchecked")
public class SampleChineseSort {

	@SuppressWarnings("rawtypes")
	private final static Comparator CHINA_COMPARE = Collator.getInstance(java.util.Locale.CHINA);

	public static void main(String []args) {
		sortArray();
		sortList();
		//System.out.println("����".compareTo("����"));//ǰ�ߴ��ں��ߣ���Ϊ�������Ϊ�������Ϊ0
	}

	
	private static void sortList() {
		List<String>list = Arrays.asList("����", "����", "����");
		Collections.sort(list , CHINA_COMPARE);
		for(String str : list) {
			System.out.println(str);
		}
	}

	private static void sortArray() {
		String[] arr = {"����", "����", "����"};
		Arrays.sort(arr, CHINA_COMPARE);
		for(String str : arr) {
			System.out.println(str);
		}
	}
}
