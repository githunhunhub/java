/*
随意输入任意个整数，输入0结束，判断偶数和奇数个数
*/

import java.util.Scanner;
class Test1{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int a = 0; //用于计数
		int b = 0;
		
		//无限循环一定要避免死循环，要有终止条件执行break.
		//for的无限循环
		for(;;) {
			System.out.println("请输入");
			int num = s.nextInt();
			if( num == 0){
				break;
			}else if(num % 2 != 0){
				a++;
			}else if(num % 2 == 0){
				b++;
			}
		}
		
		//while无限循环
		//只用把for(;;)改为while(true)
		
		System.out.println("奇数的个数是：" + a);
		System.out.println("偶数的个数是：" + b);
	}
}