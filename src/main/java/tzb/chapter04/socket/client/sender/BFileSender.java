package tzb.chapter04.socket.client.sender;

import static tzb.chapter04.socket.Commons.DEFAULT_MESSAGE_CHARSET;
import static tzb.chapter04.socket.Commons.SEND_B_FILE;
import static tzb.chapter04.socket.Commons.println;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import tzb.chapter04.socket.SocketWrapper;

/**
 * ����Ϊ�������ļ����͵���
 * @author Administrator
 *
 */
public class BFileSender implements Sendable {
	
	protected File file;
	
	protected long fileLength;
	
	protected int minLength = 2;
	
	public BFileSender(String []tokens) throws IOException {
		if (tokens.length >= minLength) {
			file = new File(tokens[1]);
			if (!file.exists()) {
				throw new FileNotFoundException("�ļ���" + tokens[1]
						+ " δ�ҵ����뷢�ͱ��ش��ڵ��ļ���");
			}
			this.fileLength = file.length();
		} else {
			throw new RuntimeException("��Ϣ��ʽ�������⣬��ʹ��help����鿴�����ʽ��");
		}
	}

	@Override
	public void sendContent(SocketWrapper socketWrapper) throws IOException {
		println("�Ҵ�ʱ��������˷��Ͷ������ļ����ļ���СΪ��" + this.fileLength);
		sendCharset(socketWrapper);
		//�ļ���
		byte[] fileNameBytes = file.getName().getBytes(DEFAULT_MESSAGE_CHARSET);
		socketWrapper.write((short) fileNameBytes.length);
		socketWrapper.write(fileNameBytes);
		int status = socketWrapper.readInt();
		if(status != 1) {//�������˷����Ƿ���Լ����ϴ������������������ϴ���
			processErrorStatus(status);
		}
		// �ļ�����&����
		socketWrapper.write(this.fileLength);
		socketWrapper.writeFile(file.getPath());
		status = socketWrapper.readInt();
		if(status != 1) {
			processErrorStatus(status);
		}else {
			println("�ļ����ͳɹ����Ѿ��ɹ����浽��������.......");
		}
	}
	
	private void processErrorStatus(int status) throws IOException {
		if (status == -1) {
			throw new RuntimeException("�������˱���ʧ�ܣ����ڷ��������Ѿ����ڸ��ļ�����..");
		} else if (status != 1) {
			throw new IOException("�������˱���ʧ�ܣ���ȷ������ԭ�򣬳��򽫽�������....");
		}
	}
	
	protected void sendCharset(SocketWrapper socketWrapper) throws IOException {
		/*����Լ̳�Ŷ*/
	}

	@Override
	public byte getSendType() {
		return SEND_B_FILE;
	}
}
