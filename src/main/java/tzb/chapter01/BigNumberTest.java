package tzb.chapter01;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberTest {

    private static String lPad(String now , int expectLength , char paddingChar) {
        if(now == null || now.length() > expectLength) {
            return now;
        }
        StringBuilder buf = new StringBuilder(expectLength);
        for(int i = 0 , paddingLength = expectLength - now.length() ; i < paddingLength ; i++) {
            buf.append(paddingChar);
        }
        return buf.append(now).toString();
    }

    public static void main(String []args) {
        //�������long�ǷŲ��µ�
        BigDecimal bigDecimal = new BigDecimal("1233243243243243243243243243243243241432423432");
        System.out.println("���ֵ�ԭʼֵ�ǣ�" + bigDecimal);

        //bigDecimal = bigDecimal.add(BigDecimal.TEN);
        //System.out.println("���10�Ժ�" + bigDecimal);

        //����������
        byte[] bytes = bigDecimal.toBigInteger().toByteArray();
        for(byte b : bytes) {
            String bitString = Integer.toBinaryString(b & 0xff);
            System.out.println(lPad(bitString , 8 , '0'));
        }
        //��ԭ���
        BigInteger bigInteger = new BigInteger(bytes);
        System.out.println("��ԭ���Ϊ��" + bigInteger);
    }
}
