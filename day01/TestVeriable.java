// ����
// 1.java�б��������ʽ��

class TestVeriable{
	public static void main(String[] args){
		//2.����Ҫ�ȶ��壬����
		int myInt1 = 11;
		double d = 12.111;
		
		System.out.println(myInt1);
		System.out.println(d + myInt1);
		
		//3.���ͣ�byte short int(Ĭ������) long
		byte b1 = 12;
		short s1 = 128;
		int i1 = 12;
		long l1 = 21341235;
		System.out.println(l1);
		
		//4.�����ͣ�float double(Ĭ�ϸ�������)
		double d1 = 12.3;
		//float����ĩβҪ�� F
		float f1 = 12.3F;
		System.out.println(f1);
		
		//5.�ַ���
		char c1 = 'a';  //charֻ��һ���ַ�
		char c2 = '\u1234';
		String str1 = "abc";
		System.out.println(c2);
		System.out.println("abc" + c1 + str1);
		
		//6.�������ͣ�ֻ��true��false����null
		boolean bool1 = true;
		if(bool1){
			System.out.println("����\"ʹ��\"��");
		}
		else{
			System.out.println("�ȼ����Ե�");
		}
	}
	
	public void method1(){
		int i1 = 123;
		System.out.println(i1);
	}
}