package com.hunhun.java;
/*
 * 1.IO����ϵ,����һ���û������������ٶȽϿ�
 * �������			�ڵ������ļ�����			����������������һ�֣�
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
		System.out.println("���ƻ���ʱ�䣺" + (end - strat) + "ms");
	}

	// ʵ���ļ����Ƶķ���
	public void copyFile(String src, String dest) {
		// 1.�ṩ���롢д���ļ�
		File file1 = new File(src);
		File file2 = new File(dest);
		// 2.������Ӧ����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.ʵ���ļ�����
			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1) {
				// fos.write(b); //����д��
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
		// 1.�ṩ���롢д���ļ�
		File file1 = new File("E:\\java\\IO\\111.jpg");
		File file2 = new File("E:\\java\\IO\\222.jpg");
		// 2.������Ӧ����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.ʵ���ļ�����
			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1) {
				// fos.write(b); //����д��
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
		// 1.����File���󣬱���д���ļ�·�����ļ�������������ļ����Բ����ڣ����Զ������������ڻḲ��
		File file = new File("hello2.txt");
		// 2.����FileOutputStream���󣬰�file������Ϊ�βδ�����
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			// 3��д�����
			fos.write(new String("I love China I love World.").getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 4.�ر������
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
			byte[] b = new byte[5]; // ��ȡ��������Ҫд������
			int len; // ÿ�ζ��뵽byte�е��ֽڳ��ȡ�
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
	// ʹ��try-catch�����쳣����
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
			// �ر���Ӧ��
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	// ��ȡһ���ļ����ݵ�������,����ȡ���ļ�һ��Ҫ����
	public void testFileInputStream1() throws Exception {
		// 1.����File�����
		File file = new File("hello.txt");
		// 2.����FileInputStream����
		FileInputStream fis = new FileInputStream(file);
		// 3.����FielInputStream�ķ�����ʵ��file�ļ���ȡ��
		// int b = fis.read(); //read()һ�ζ�ȡһ���ֽڣ�������β����-1
		// while (b != -1) {
		// System.out.print((char)b);
		// b = fis.read();
		// }

		int b;
		while ((b = fis.read()) != -1) {
			System.out.print((char) b);
		}
		// �ر���Ӧ����
		fis.close();
	}
}
