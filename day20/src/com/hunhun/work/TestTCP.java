package com.hunhun.work;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.junit.Test;

/*
 * 以下异常请用try-catch-finally,以保证即使错误仍能执行close()
 */
public class TestTCP {
	@Test
	public void client() {
		// 1.
		Socket socket = null;
		// 2.
		OutputStream os = null;
		Scanner scanner = null;
		// 4.
		InputStream is = null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
			os = socket.getOutputStream();
			// 3.
			System.out.println("Please input: ");
			scanner = new Scanner(System.in);
			String str = scanner.next();
			os.write(str.getBytes());
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b = new byte[10];
			int len;
			while ((len = is.read(b)) != -1) {
				String str1 = new String(b, 0, len);
				System.out.println(str1);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (scanner != null) {
				scanner.close();
			}
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
	public void server() throws Exception{ //此处异常应该和上面一样的的处理方法
		// 1.
		ServerSocket ss = new ServerSocket(9090);
		// 2.
		Socket s = ss.accept();
		// 3.
		InputStream is = s.getInputStream();
		byte[] b = new byte[10];
		int len;
		String str = new String();
		while ((len = is.read(b)) != -1) {
			String str1 = new String(b, 0, len);
			str += str1;
		}
		String strUpperCase = str.toUpperCase();
		// 4.
		OutputStream os = s.getOutputStream();
		os.write(strUpperCase.getBytes());
		// 5.
		os.close();
		is.close();
		s.close();
		ss.close();
	}
}
