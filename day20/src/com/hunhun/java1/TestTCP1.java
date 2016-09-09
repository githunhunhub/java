package com.hunhun.java1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;
/*
 * 例1：客户端发一条信息给服务端
 */
public class TestTCP1 {
	@Test
	// 客户端
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		try {
			//1.创建Socket对象，并通过构造器指明IP和Port
			socket = new Socket("127.0.0.1", 9090);
			//2.发送数据，方法返回一个OutputStream对象
			os = socket.getOutputStream();
			//3.具体输出过程
			os.write("我是客户端！当你看到时发送成功。".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//4.关闭相应的流和socket
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
	// 服务端
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		try {
			//1.创建ServerSocket对象，指明Port
			ss = new ServerSocket(9090);
			//2.调用accpet（）方法
			s = ss.accept();
			//3.调用Socket的getInputStream（）获取客户端发送的数据流
			is = s.getInputStream();
			//4.对获取的数据进行操作
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
			}
			System.out.println("收到来自：" + s.getInetAddress()+ "的数据。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5.关闭相应的流
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
