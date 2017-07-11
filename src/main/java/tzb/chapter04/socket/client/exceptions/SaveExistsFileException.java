package tzb.chapter04.socket.client.exceptions;

public class SaveExistsFileException extends RuntimeException {

	private static final long serialVersionUID = -1026575092082314002L;
	
	public SaveExistsFileException(String path) {
		super("�����ļ�:" + path + "ʧ�ܣ���Ϊ�ļ��Ѿ������ˡ�");
	}
	
}
