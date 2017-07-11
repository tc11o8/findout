package tzb.chapter04.file;

import java.io.IOException;
import java.nio.ByteBuffer;

public class CopyFileTestMain {
	
	public static void main(String []args) throws IOException {
		copyFileByHeapByteBuffer();
	}
	
	public static void copyFileByStreamTest() throws IOException {
		long start = System.currentTimeMillis();
		FileUtils.copyFile("d:/�Ա�Java���߰�װ��.exe", "d:/�Ա�Java���߰�װ��2222.exe");
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void copyFileByDirectByteBuffer() throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024);
		long start = System.currentTimeMillis();
		FileUtils.copyFileByByteBuffer("d:/�Ա�Java���߰�װ��.exe", "d:/�Ա�Java���߰�װ��2222.exe", byteBuffer, false);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void copyFileByHeapByteBuffer() throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
		long start = System.currentTimeMillis();
		FileUtils.copyFileByByteBuffer("d:/�Ա�Java���߰�װ��.exe", "d:/�Ա�Java���߰�װ��2222.exe", byteBuffer, false);
		System.out.println(System.currentTimeMillis() - start);
	}

}
