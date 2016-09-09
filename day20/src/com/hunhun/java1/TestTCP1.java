package com.hunhun.java1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;
/*
 * ��1���ͻ��˷�һ����Ϣ�������
 */
public class TestTCP1 {
	@Test
	// �ͻ���
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		try {
			//1.����Socket���󣬲�ͨ��������ָ��IP��Port
			socket = new Socket("127.0.0.1", 9090);
			//2.�������ݣ���������һ��OutputStream����
			os = socket.getOutputStream();
			//3.�����������
			os.write("���ǿͻ��ˣ����㿴��ʱ���ͳɹ���".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//4.�ر���Ӧ������socket
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	// �����
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		try {
			//1.����ServerSocket����ָ��Port
			ss = new ServerSocket(9090);
			//2.����accpet��������
			s = ss.accept();
			//3.����Socket��getInputStream������ȡ�ͻ��˷��͵�������
			is = s.getInputStream();
			//4.�Ի�ȡ�����ݽ��в���
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
			}
			System.out.println("�յ����ԣ�" + s.getInetAddress()+ "�����ݡ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5.�ر���Ӧ����
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
}
