/*
打印1-15之间是3的倍数的数的个数
*/

class Test2{
	public static void main(String[] args){
		int d = 0;
		for(int i=1; i<=15; i++){
			if(i % 3 == 0){
				d++;
			}
		}
		System.out.println("1-15之间是3的倍数的数的个数是: "+ d);
	}
}