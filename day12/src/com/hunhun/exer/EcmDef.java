package com.hunhun.exer;

public class EcmDef {
	public static void main(String[] args) {
		try {
			int i = Integer.parseInt(args[0]);//被除数
			int j = Integer.parseInt(args[1]);//除数
			ecm(i, j);
		} catch (NumberFormatException e) {
			System.out.println("数据类型不一致！");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("缺少命令行参数");
		}catch (ArithmeticException e) {
			System.out.println("分母为零！");
		}catch (EcDef e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public static void ecm(int i, int j) throws EcDef{
		if (i<0 || j<0) {
			throw new EcDef("输入数据存在负数！");
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
