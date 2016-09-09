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
 * 例3：客户端发文件给服务端，服务端收到后保存在本地，并返回信息给客户端
 */
public class TestTCP3 {
	@Test
	public void client() throws Exception{//此处处理异常应该用try-catch-finally,
		//1.创建Socket对象
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
		//2.从本地获取一个文件并发送
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("1.jpg"));
		byte[] b = new byte[1024];
		int len;
		while ((len = fis.read(b)) != -1) {
			os.write(b, 0, len);
		}
		socket.shutdownOutput();
		//3.接收服务端信息
		InputStream is = socket.getInputStream();
		byte[] b1= new byte[1024];
		int len1;
		while((len1 = is.read(b1))!=-1){
			String str = new String(b1, 0, len1);
			System.out.println(str);
		}
		//4.关闭相应流和Socket对象
		is.close();
		os.close();
		fis.close();
		socket.close();
	}

	@Test
	public void service() throws Exception{	//处理异常应该用try-catch-finally
		// 1.创建ServerSocket的对象				
		ServerSocket ss = new ServerSocket(9090);
		// 2.调用accept()方法，返回Socket对象
		Socket s = ss.accept();
		// 3.保存客户端发送的文件
		InputStream is = s.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("2.jpg"));

		byte[] b = new byte[1024];
		int len;
		while ((len = is.read(b)) != -1) {
			fos.write(b, 0, len);
		}
		System.out.println("收到来自："+ s.getInetAddress().getHostName());
//		s.shutdownOutput();
		//4.发送反馈信息给客户端
		OutputStream os = s.getOutputStream();
		os.write("已经收到。".getBytes());
		
		os.close();
		fos.close();
		is.close();
		s.close();
		ss.close();
	}
}
