// 变量
// 1.java中变量定义格式：

class TestVeriable{
	public static void main(String[] args){
		//2.变量要先定义，再用
		int myInt1 = 11;
		double d = 12.111;
		
		System.out.println(myInt1);
		System.out.println(d + myInt1);
		
		//3.整型：byte short int(默认类型) long
		byte b1 = 12;
		short s1 = 128;
		int i1 = 12;
		long l1 = 21341235;
		System.out.println(l1);
		
		//4.浮点型：float double(默认浮点类型)
		double d1 = 12.3;
		//float类型末尾要加 F
		float f1 = 12.3F;
		System.out.println(f1);
		
		//5.字符型
		char c1 = 'a';  //char只能一个字符
		char c2 = '\u1234';
		String str1 = "abc";
		System.out.println(c2);
		System.out.println("abc" + c1 + str1);
		
		//6.布尔类型：只有true和false，无null
		boolean bool1 = true;
		if(bool1){
			System.out.println("卡即\"使对\"方");
		}
		else{
			System.out.println("等级考试的");
		}
	}
	
	public void method1(){
		int i1 = 123;
		System.out.println(i1);
	}
}