package com.hunhun.eser;

public class TestBoyGirl {
	public static void main(String[] args) {
		Boy boy = new Boy();
		boy.setAge(23);
		boy.setNama("ABCD");
		
		Girl girl = new Girl();
		girl.setName("ASD");
		
		boy.marry(girl);
		boy.shout();
		System.out.println();
		girl.marry(boy);
	}
}
