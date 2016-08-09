/*
输出三位数水仙花数，如：153=1*1*1 + 5*5*5 + 3*3*3
*/

class ShuiXian{
	public static void main(String[] args){
		
		for (int i = 100; i < 1000; i++){
			int b = i/100;
			int s = (i - b*100)/10;
			int g = i % 10;
			if(i == b*b*b + s*s*s + g*g*g){
				System.out.println(i);
			}
		}
	}
}