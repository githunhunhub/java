
// 生成时用：javac -encoding utf-8 xxx.java
import java.util.Scanner;
class big{
	public static void main(String[] args){
		//1.从键盘获三个数
		Scanner s = new Scanner(System.in);
		System.out.print("请输入第一个数: ");
		int num1 = s.nextInt();
		System.out.print("请输入第二个数: ");
		int num2 = s.nextInt();
		System.out.print("请输入第三个数: ");
		int num3 = s.nextInt();
		
		//2.对三个数排序
		System.out.println("三个数从大到小是：");
		if(num1 > num2){
			if(num3 > num1){
				System.out.println(num3 +"," +num1 +"," +num2);
			}else if(num3 < num2){
				System.out.println(num1 +"," +num2 +"," +num3);
			}else{
				System.out.println(num1 +"," +num2 +"," +num3);
			}
		}else{
			if(num1 > num3){
				System.out.println(num2 +"," +num1 +"," +num3);
			}else if(num3 > num2){
				System.out.println(num3 +"," +num2 +"," +num1);
			}else{
				System.out.println(num2 +"," +num3 +"," +num1);
			}
		}
	}
}