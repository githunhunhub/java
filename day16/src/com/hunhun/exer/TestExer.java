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
	// 字符流实现文件的复制
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
	// 字符流实现输入
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
	// 字符流实现输出
	public void test2() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("test1.txt"));

			String str = "Java是一门面向对象编程语言，不仅吸收了C++语言\n" + "的各种优点，还摒弃了C++里难以理解的多继承、指针等\n"
					+ "概念，因此Java语言具有功能强大和简单易用两个特征。\n" + "Java语言作为静态面向对象编程语言的代表，极好地实现\n"
					+ "了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程";

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
	// 字节流实现内容输出
	public void test1() {
		// File file = new File("test.txt");
		// FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(new File("test.txt")));

			String str = "Java是一门面向对象编程语言，不仅吸收了C++语言\n" + "的各种优点，还摒弃了C++里难以理解的多继承、指针等\n"
					+ "概念，因此Java语言具有功能强大和简单易用两个特征。\n" + "Java语言作为静态面向对象编程语言的代表，极好地实现\n"
					+ "了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程";
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
