package com.hunhun.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestBuffered {
	@Test
	public void testBufferedReader() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File file = new File("dbcp.txt");
			File file2 = new File("dbcp3.txt");
			FileReader fr = new FileReader(file);
			FileWriter fw = new FileWriter(file2);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

//			char[] c = new char[1024];
//			int len;
//			while ((len = br.read(c)) != -1) {
//				String str = new String(c, 0, len);
//				System.out.print(str);
//			}
			
			String str;
			while((str = br.readLine())!=null){
//				System.out.println(str);	//输出
				bw.write(str + "\n");
//				bw.newLine();//或者用newLine()换行
				bw.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bw!= null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void testCopyFile() {
		String src = "e:/java/IO/111.jpg";
		String dest = "e:/java/IO/444.jpg";
		copyFile(src, dest);
	}

	// 通用缓冲流文件复制
	public void copyFile(String src, String dest) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File file1 = new File(src);
			File file2 = new File(dest);

			// 2.创建节点流
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			// 4.具体实现
			byte[] b = new byte[1024];
			int len;
			
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush(); // 刷新一下
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.关闭
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void testBufferedInputStream() {
		// 1.提供文件对象
		// 3.将节点流对象作为形参传入缓冲流中
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File file1 = new File("e:/java/IO/111.jpg");
			File file2 = new File("e:/java/IO/333.jpg");

			// 2.创建节点流
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			// 4.具体实现
			byte[] b = new byte[1024];
			int len;
			;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.关闭
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
