package question;

import java.util.ArrayList;

public class StringIntern {

	public static void main(String[] args) {

	
		
		String str = "234.010";
		String result=null;
		int index = str.indexOf(".");
		if(index>0){
			char[] array = str.substring(index).toCharArray();
			int len = array.length-1;
			int pot = 0;
			for(int i = len;i>=0;i--){
				if(array[i]=='0'||array[i]=='.'){
					pot++;
				}else {
					break;
				}
			}
			if(pot>0){
				result = str.substring(0, str.length()-pot);
			}
		}else{
			result = str;
		}
		System.out.println(result);
		
		// String s = new String("1");
		// s.intern();
		// String s2 = "1";
		// System.out.println(s==s2);
		//
		// String s3 = new String("1")+new String("1");
		// s3.intern();
		// String s4 = "11";
		// System.out.println(s3==s4);

//		ArrayList<String> list = new ArrayList<String>();
//		int i = 0;
//		while (true) {
//			list.add(String.valueOf(i++).intern());
//		}
//
		
//		String str1 = new StringBuilder("计算机").append("软件").toString();
//
//		System.out.println(str1.intern() == str1);
//
//		String str2 = new StringBuilder("ja").append("va").toString();
//
//		System.out.println(str2.intern() == str2);

		// String str = "abc";
		// char[] array = {'a', 'b', 'c'};
		// String str2 = new String(array);

		// String str2 = new String("abc");
		// 使用intern()将str2字符串内容放入常量池
		// str2 = str2.intern();
		// 这个比较用来说明字符串字面常量和我们使用intern处理后的字符串是在同一个地方
		// System.out.println(str == str2);
		// 那好，下面我们就拼命的intern吧
		// ArrayList<String> list = new ArrayList<String>();
		// for (int i = 0; i < 1000000000; i++) {
		// String temp = String.valueOf(i).intern();
		// list.add(temp);
		// }
		
		
	}

}
