package com.hunhun.exer;

public class EcmDef {
	public static void main(String[] args) {
		try {
			int i = Integer.parseInt(args[0]);//������
			int j = Integer.parseInt(args[1]);//����
			ecm(i, j);
		} catch (NumberFormatException e) {
			System.out.println("�������Ͳ�һ�£�");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ȱ�������в���");
		}catch (ArithmeticException e) {
			System.out.println("��ĸΪ�㣡");
		}catch (EcDef e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public static void ecm(int i, int j) throws EcDef{
		if (i<0 || j<0) {
			throw new EcDef("�������ݴ��ڸ�����");
		} else {
			System.out.println(i/j);
		}
	}
}

class EcDef extends Exception{
	static final long serialVersionUID = -338993124229948L;
	
	public EcDef(){
		super();
	}
	
	public EcDef(String msg){
		super(msg);
	}
}
