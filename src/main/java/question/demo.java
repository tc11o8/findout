package question;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

class demo {

	public static void changeStr(String str) {
		str = "welcome";
	}

	public static void main(String[] args) {

		lableB: 
			for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(j);
				if (j == 1) {
					break lableB;
				}
			}
		}
		System.out.println("over!");

		int number = 10;
		String qq = Integer.toBinaryString(9);
		System.out.println(qq);
		Integer cInteger = (number - 1) << 1;
		System.out.println(cInteger);
		int g = Integer.highestOneBit(cInteger);
		System.out.println(g);

		int d = 2 << 3; // 2*2*2
		System.out.println(d);

		int a = 16 >> 2; // 2*2*2
		System.out.println(a);

		// {
		// byte[] placeholder = new byte[64*1024*1024];
		// }
		// int a=0;
		// System.gc();

		// BigDecimal demandMoney =
		// BigDecimal.valueOf(Float.valueOf("3000000"));
		// BigDecimal investMoney = BigDecimal.valueOf(Float.valueOf("10000"));
		//
		// if(investMoney.divide(demandMoney,3,BigDecimal.ROUND_HALF_UP).compareTo(new
		// BigDecimal("0.9"))>=0){
		// System.out.println("true");
		// }
		// else {
		// System.out.println("false");
		// }

		// List<String> list = new ArrayList<String>();
		// list.add("AA");
		// list.add("BB");
		// list.add("CC");
		//
		// System.out.println(list.toArray().toString());
		// System.out.println(list.toString());

		// byte i = 4;
		//
		// if(Byte.valueOf(i).equals(new Byte("4"))){
		// System.out.println("1");
		// }
		//
		// if(i!=4){
		// System.out.println(1);
		// }
		// else {
		// System.out.println(2);
		// }

		// String title = "做个。，好的";
		//
		// try {
		// String input =URLEncoder.encode(title, "UTF-8");
		//
		// System.out.println(input);
		//
		// String output = URLDecoder.decode(input, "UTF-8");
		//
		// System.out.println(output);
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// }

		// String aString = encode(title.getBytes());
		//
		// byte[] bs= decode(aString.getBytes());
		//
		// String dd = bs.toString();
		//
		// String encode=base64Encoding(title);
		//
		// String decode = base64Decoding(encode);
	}

	public static String base64Encoding(String contents) {
		if (contents != null)
			return Base64.encodeBase64(contents.getBytes()).toString();
		else
			return null;
	}

	public static String base64Decoding(String contents) {
		if (contents != null)
			return Base64.decodeBase64(contents).toString();
		else
			return null;
	}

	public static byte[] decode(final byte[] bytes) {
		return Base64.decodeBase64(bytes);
	}

	public static String encode(final byte[] bytes) {
		return new String(Base64.encodeBase64(bytes));
	}
}
