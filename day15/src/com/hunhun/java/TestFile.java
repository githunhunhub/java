package com.hunhun.java;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 * 1.输入、输出相关接口、类都在java.io包下
 * 2.File类对应文件和文件目录
 * 3.File类的对象与平台无关
 * 4.File中的方法仅设计创建、删除、命名等，对文件具体内容无效，而由IO流实现
 * 5.File类对象常作为IO流的具体类构造器形参
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
			boolean b = file2.mkdir(); // mkdirs()创建多层目录
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
		// 具体文件
		File file1 = new File("E:/java/IO/Hello.txt");// 绝对路径
		File file2 = new File("world1.txt");// 相对路径
		// 文件夹
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

		// renameTo(File new):重命名
		// file1.renameTo(file2);//file2文件不能存在
		boolean b = file1.renameTo(file2);// file会被改名为file2并且路径也会改到file2
		System.out.println(b);

	}

}
