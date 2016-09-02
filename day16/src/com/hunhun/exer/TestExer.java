package com.hunhun.exer;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestExer {
	@Test
	// �ַ���ʵ���ļ��ĸ���
	public void test4() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("test1.txt"));
			bw = new BufferedWriter(new FileWriter("test1copy.txt"));

			String str;
			while ((str = br.readLine()) != null) {
				bw.write("copy" + str + "\n");
				bw.flush();
			}
			
//			char[] c = new char[20];
//			int len;
//			while((len = br.read(c))!= -1){
//				bw.write(c, 0, len);
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
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
	// �ַ���ʵ������
	public void test3() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test1.txt"));
			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	// �ַ���ʵ�����
	public void test2() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("test1.txt"));

			String str = "Java��һ��������������ԣ�����������C++����\n" + "�ĸ����ŵ㣬��������C++���������Ķ�̳С�ָ���\n"
					+ "������Java���Ծ��й���ǿ��ͼ���������������\n" + "Java������Ϊ��̬������������ԵĴ������õ�ʵ��\n"
					+ "������������ۣ��������Ա�����ŵ�˼ά��ʽ���и��ӵı��";

			bw.write(str);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	// �ֽ���ʵ���������
	public void test1() {
		// File file = new File("test.txt");
		// FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(new File("test.txt")));

			String str = "Java��һ��������������ԣ�����������C++����\n" + "�ĸ����ŵ㣬��������C++���������Ķ�̳С�ָ���\n"
					+ "������Java���Ծ��й���ǿ��ͼ���������������\n" + "Java������Ϊ��̬������������ԵĴ������õ�ʵ��\n"
					+ "������������ۣ��������Ա�����ŵ�˼ά��ʽ���и��ӵı��";
			bos.write(str.getBytes());
			bos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
