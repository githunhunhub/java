package com.hunhun.java;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 * 1.���롢�����ؽӿڡ��඼��java.io����
 * 2.File���Ӧ�ļ����ļ�Ŀ¼
 * 3.File��Ķ�����ƽ̨�޹�
 * 4.File�еķ�������ƴ�����ɾ���������ȣ����ļ�����������Ч������IO��ʵ��
 * 5.File�������ΪIO���ľ����๹�����β�
 */
public class TestFile {
	@Test
	public void test3() throws IOException {
		File file1 = new File("E:/java/IO/HelloWorld.txt");
		File file2 = new File("E:/java/IO/IO2");

		System.out.println(file1.delete());
		if (!file1.exists()) {
			boolean b = file1.createNewFile();
			System.out.println(b);
		}
		System.out.println("--------------");
		if (!file2.exists()) {
			boolean b = file2.mkdir(); // mkdirs()�������Ŀ¼
			System.out.println(b);
		} else {
			System.out.println("have exist!");
		}
		System.out.println("--------------");
		File file3 = new File("E:/java/IO");
		String[] strs = file3.list();
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i] + "  ");
		}
		System.out.println();
		System.out.println("------------");
		File[] files = file3.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName());
		}
	}

	@Test
	public void test2() {
		File file1 = new File("E:/java/IO/HelloWorld.txt");
		File file2 = new File("E:/java/IO");

		System.out.println(file1.exists());
		System.out.println(file1.canWrite());
		System.out.println(file1.canRead());
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(new Date(file1.lastModified()));
		System.out.println(file1.length());

		System.out.println("----------");

		System.out.println(file2.exists());
		System.out.println(file2.canWrite());
		System.out.println(file2.canRead());
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory());
		System.out.println(new Date(file2.lastModified()));
		System.out.println(file2.length());
	}

	@Test
	public void test1() {
		// �����ļ�
		File file1 = new File("E:/java/IO/Hello.txt");// ����·��
		File file2 = new File("world1.txt");// ���·��
		// �ļ���
		File file3 = new File("E:/java/IO");

		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getAbsoluteFile());
		System.out.println(file1.getParent());
		System.out.println(file1.getAbsolutePath());

		System.out.println("------------");

		System.out.println(file3.getName());
		System.out.println(file3.getPath());
		System.out.println(file3.getAbsoluteFile());
		System.out.println(file3.getParent());
		System.out.println(file3.getAbsolutePath());

		// renameTo(File new):������
		// file1.renameTo(file2);//file2�ļ����ܴ���
		boolean b = file1.renameTo(file2);// file�ᱻ����Ϊfile2����·��Ҳ��ĵ�file2
		System.out.println(b);

	}

}
