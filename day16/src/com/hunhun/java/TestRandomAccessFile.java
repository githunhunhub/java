package com.hunhun.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class TestRandomAccessFile {
	@Test
	//相较于test3更通用
	public void test4(){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(
					new File("hello1.txt"), "rw");
					
			raf.seek(3);
			byte[] b = new byte[10];
			int len;
			StringBuffer sb = new StringBuffer();
			while((len = raf.read(b))!=-1){
				sb.append(new String(b,0,len));
			}
			raf.seek(3);
			raf.write("xy".getBytes());
			raf.write(sb.toString().getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(raf!=null){
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void test3(){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(
					new File("hello1.txt"), "rw");
			raf.seek(3);
			String str = raf.readLine();
			raf.seek(3);
			raf.write("XY".getBytes());
			raf.write(str.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(raf!=null){
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void test2(){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(
					new File("hello.txt"), "rw");
			raf.seek(3);	//覆盖操作
			raf.write("BBBB".getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(raf!=null){
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	@Test
	public void test1(){
		RandomAccessFile raf1 = null;
		RandomAccessFile raf2 = null;
		try {
			raf1 = new RandomAccessFile(
					new File("hello.txt"), "r");
			raf2 = new RandomAccessFile(
					new File("hello1.txt"), "rw");
			
			byte[] b = new byte[20];
			int len;
			while((len = raf1.read(b))!= -1){
				raf2.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(raf2 != null){
				try {
					raf2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(raf1 != null){
				try {
					raf1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
}
