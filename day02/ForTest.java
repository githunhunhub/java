/*
打印1-150，并且在3的倍数打印foo,5的倍数打印biz,7的倍数打印baz
*/

class ForTest{
	public static void main(String[] args){
		
		for (int i = 1; i <=150; i++){
			System.out.print(i + " ");
			
			if(i % 3 ==0){
				System.out.print("三倍 ");
			}
			if(i % 5 ==0){
				System.out.print("五倍 ");
			}
			if(i % 7 ==0){
				System.out.print("七倍 ");
			}
			System.out.println();
		}
	}
}