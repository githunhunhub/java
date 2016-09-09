package com.hunhun.java1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/*
 * ��3���ͻ��˷��ļ�������ˣ�������յ��󱣴��ڱ��أ���������Ϣ���ͻ���
 */
public class TestTCP3 {
	@Test
	public void client() throws Exception{//�˴������쳣Ӧ����try-catch-finally,
		//1.����Socket����
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
		//2.�ӱ��ػ�ȡһ���ļ�������
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("1.jpg"));
		byte[] b = new byte[1024];
		int len;
		while ((len = fis.read(b)) != -1) {
			os.write(b, 0, len);
		}
		socket.shutdownOutput();
		//3.���շ������Ϣ
		InputStream is = socket.getInputStream();
		byte[] b1= new byte[1024];
		int len1;
		while((len1 = is.read(b1))!=-1){
			String str = new String(b1, 0, len1);
			System.out.println(str);
		}
		//4.�ر���Ӧ����Socket����
		is.close();
		os.close();
		fis.close();
		socket.close();
	}

	@Test
	public void service() throws Exception{	//�����쳣Ӧ����try-catch-finally
		// 1.����ServerSocket�Ķ���				
		ServerSocket ss = new ServerSocket(9090);
		// 2.����accept()����������Socket����
		Socket s = ss.accept();
		// 3.����ͻ��˷��͵��ļ�
		InputStream is = s.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("2.jpg"));

		byte[] b = new byte[1024];
		int len;
		while ((len = is.read(b)) != -1) {
			fos.write(b, 0, len);
		}
		System.out.println("�յ����ԣ�"+ s.getInetAddress().getHostName());
//		s.shutdownOutput();
		//4.���ͷ�����Ϣ���ͻ���
		OutputStream os = s.getOutputStream();
		os.write("�Ѿ��յ���".getBytes());
		
		os.close();
		fos.close();
		is.close();
		s.close();
		ss.close();
	}
}
