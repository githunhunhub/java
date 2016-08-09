/*
输出100内的质数
*/

class Prime{
	public static void main(String[] args){
		//boolean flag = false;
		long start = System.currentTimeMillis(); //获取当前系统时间毫秒数
		l:for(int i = 2; i <= 100000; i++){
			//判断i是否是质数
			for(int j = 2; j <= Math.sqrt(i); j++){
				if(i % j ==0){
					//flag = true;
					//break;
					continue l; //执行continue
				}
			}
			//if(flag == false){
				System.out.print(i + "  ");
			//}
			//flag = false; //此处重置flag
		}
		long end = System.currentTimeMillis();
		System.out.println("所花费时间为：" + (end - start));
	}
}