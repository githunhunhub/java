package com.hunhun.java;

public class MyException extends RuntimeException{
	//全局常量
	static final long serialVersionUID = -70348975766939L;
	
	public MyException(){
		
	}
	public MyException(String msg){
		super(msg);
	}
}
