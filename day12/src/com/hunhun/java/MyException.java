package com.hunhun.java;

public class MyException extends RuntimeException{
	//ȫ�ֳ���
	static final long serialVersionUID = -70348975766939L;
	
	public MyException(){
		
	}
	public MyException(String msg){
		super(msg);
	}
}
