package tzb.chapter02.samplesocket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

	public static void main(String []args) throws IOException, InterruptedException {
		Scanner scanner = new Scanner(System.in);
		SocketWrapper socket = new SocketWrapper(new Socket("localhost" , 8888));
		try {
			System.out.println("�Ѿ������Ϸ������ˣ����ڿ���������ݿ�ʼͨ����");
			String sendMsg = scanner.nextLine();
			socket.writeLine(sendMsg);//������Ϣ
			String recivedMsg = socket.readLine();
			while(!"close".equals(recivedMsg)) {
				System.out.println("===�����������ء�===>" + recivedMsg);
				sendMsg = scanner.nextLine();
				socket.writeLine(sendMsg);//������Ϣ
				recivedMsg = socket.readLine();
			}
			//�ָ�ע�͵��ⲿ�ִ��룬���ſ��ͻᱨ��Ŷ������ԭ����Ȼ����
			//socket.writeLine("��Ϣ������Ϣ������Ϣ������Ϣ������Ϣ������Ϣ��");
			//socket.writeLine(" ������Ϣ������Ϣ������Ϣ������Ϣ������Ϣ������Ϣ������Ϣ����");
			System.out.println("���ǿͻ��ˣ�������!");
		}finally {
			if(socket != null)
				socket.close();
		}
	}
}
