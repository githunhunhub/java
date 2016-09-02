package com.hunhun.java;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileReaderWriter {
	
	@Test
	//FileReader/FileWriter�ַ���ֻ�ܴ����ı��ļ������ı�ֻ�����ֽ���
	public void testFileReaderWriter(){
		//1.��������Ӧ�ļ�һ��Ҫ���ڣ�����������ڻᴴ���������򸲸�
		FileReader fr = null;
		FileWriter fw = null;
		try {
			File src = new File("dbcp.txt");
			File dest = new File("dbcp1.txt");
			//2.
			fr = new FileReader(src);
			fw = new FileWriter(dest);
			//3.
			char[] c = new char[24];
			int len;
			while((len = fr.read(c))!=-1){
				fw.write(c, 0, len);
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fw!=null){
				try {
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(fr!=null){
				try {
					fr.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	@Test
	public void testFileReader() {
		FileReader fr = null;
		try {
			File file = new File("dbcp.txt");
			fr = new FileReader(file);
			char[] c = new char[24];
			int len;
			while ((len = fr.read(c)) != -1) {
				String str = new String(c, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
