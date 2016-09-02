package com.hunhun.java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/*
 * 转换流：InputStreamReader、OutputStreamWriter
 * 
 * 标准输出流：System.out()
 * 标准输入流：System.in()
 */
import org.junit.Test;

public class TestOtherStream {
	@Test
	public void test2(){
		BufferedReader br =null;
		try {
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			System.out.println("输入字符串：");
			String str;
			while(true){
				str = br.readLine();
				if (str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")) {//忽略大小写
					break;
				}
				String str1 = str.toUpperCase();	//变成大写
				System.out.println(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br!=null){
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
	public void test1(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			//解码
			File file = new File("dbcp.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			br = new BufferedReader(isr);
			
			//编码
			File file2 = new File("dbcp4.txt");
			FileOutputStream fos = new FileOutputStream(file2);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			bw = new BufferedWriter(osw);
			
			String str;
			while((str = br.readLine())!=null){
				bw.write(str + "\n");
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
}
