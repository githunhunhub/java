/*
求1-100之间偶数和
*/

class OuShuHe{
	public static void main(String[] args){
		
		int h = 0;
		for(int i = 1; i <= 100; i++){
			if(i % 2 == 0){
				h = h + i;
			}
		}
		System.out.println("1-100之间偶数和是：" + h);
	}
}