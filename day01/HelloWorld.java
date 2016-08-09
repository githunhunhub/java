/**
这是第一个java程序
@author hunhun
@version v1.0
*/

/*
	1.源文件可有多个class声明
	2.类中可以有主方法(即main()方法),且格式固定为：public static void main (String[] args){}.
	3.main()方法是程序入口，程序执行部分
	4.一个源文件至多一个声明为public类，且public类名要和此文件的名字相同
	5.每个语句以“ ；”结尾
	6.执行程序：编译：在源文件目录下执行javac HelloWorld.java 编译完成生成相应个数.clss字节码文件；运行：java 相应class名
*/

public class HelloWorld{
	public static void main(String[] args){
		System.out.println("HelloJava!");
	}
}
/*
	1.标识符：凡是可以自己命名的地方，如：类名，方法名，变量名...
	2.标识符命名规则：26个英文大小写字母，0-9，-或$组成，不能数字开头，不能有空格，严格区分大小写
	3.命名规范：
		包名：所有字母小写 xxxyyyy
		类、接口名：所有单词首字母大写 XxxYyy
		变量、方法名：第一个单词小写，后边单词首字母大写 xxxYyyZzz
		常量名：所有单词大写，多单词下划线连接 XXX_YYY_ZZZ
*/
class TsetBiaoZhiFu{
	public static void main(String[] args){
		int static1 = 1;
		int myInt = 233;
		System.out.print("Hello!");
	}
	
	public void add(){
		
	}
}

class I_Love_Java{
	public static void main (String[] args){
		System.out.println("Name: hunhun");
		System.out.println("Address: SiChuan");
		System.out.print("\t*\t\t\t\t*\n*\t\t*  I Love Java\t*\t\t*\n\t*\t\t\t\t*\n\t\t*\t\t*\n\t\t\t*");
		
	}
}