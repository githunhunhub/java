package com.hunhun.java;
/*
 * 1.IO的体系,开发一般用缓冲流，处理速度较快
 * 抽象基类			节点流（文件流）			缓冲流（处理流的一种）
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStream		FileOutputStream		BufferedOutputStream
 * Reader			FileReader				BufferedReader
 * Writer			FileWriter				BufferedWriter
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestInputOutputStream {

	@Test
	public void testCopyFile() {
		long strat = System.currentTimeMillis();
		String src = "E:\\java\\IO\\copy.txt";
		String dest = "E:\\java\\IO\\copy00.txt";
		copyFile(src, dest);
		long end = System.currentTimeMillis();
		System.out.println("复制花费时间：" + (end - strat) + "ms");
	}

	// 实现文件复制的方法
	public void copyFile(String src, String dest) {
		// 1.提供读入、写出文件
		File file1 = new File(src);
		File file2 = new File(dest);
		// 2.创建相应的流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.实现文件复制
			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1) {
				// fos.write(b); //错误写法
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileInputOutputStream() {
		// 1.提供读入、写出文件
		File file1 = new File("E:\\java\\IO\\111.jpg");
		File file2 = new File("E:\\java\\IO\\222.jpg");
		// 2.创建相应的流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.实现文件复制
			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1) {
				// fos.write(b); //错误写法
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileOutputStream() {
		// 1.创建File对象，表明写入文件路径及文件名，输出对象文件可以不存在，会自动创建，若存在会覆盖
		File file = new File("hello2.txt");
		// 2.创建FileOutputStream对象，爸file对象作为形参传给它
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			// 3，写入操作
			fos.write(new String("I love China I love World.").getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 4.关闭输出流
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileInputStream3() {
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[5]; // 读取到的数据要写入数组
			int len; // 每次读入到byte中的字节长度、
			while ((len = fis.read(b)) != -1) {
				// for (int i = 0; i < len; i++) {
				// System.out.print((char) b[i]);
				// }
				String str = new String(b, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@Test
	// 使用try-catch处理异常更好
	public void testFileInputStream2() {
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭相应流
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	// 读取一个文件内容到程序中,所读取的文件一定要存在
	public void testFileInputStream1() throws Exception {
		// 1.创建File类对象
		File file = new File("hello.txt");
		// 2.创建FileInputStream对象
		FileInputStream fis = new FileInputStream(file);
		// 3.调用FielInputStream的方法，实现file文件读取。
		// int b = fis.read(); //read()一次读取一个字节，读到结尾返回-1
		// while (b != -1) {
		// System.out.print((char)b);
		// b = fis.read();
		// }

		int b;
		while ((b = fis.read()) != -1) {
			System.out.print((char) b);
		}
		// 关闭相应的流
		fis.close();
	}
}
