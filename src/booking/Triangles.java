package booking;

import java.util.Scanner;

public class Triangles{
	
	

	
	
	public static void main(String[] args) throws Exception{
		
		Scanner in = new Scanner(System.in);
		
		int a,b,c = -1;
		
		a= in.nextInt();
		b= in.nextInt();
		c= in.nextInt();
		
		if(a < 1 || b < 1 || c <1){
			
			throw new Exception("invalid input");
		}
		
		if(a==b && b==c){
			System.out.println(1);
		}else if(a+b > c && b+c > a && c+a > b){
			System.out.println(2);
		}else{
			System.out.println(0);
		}
		
	}
}
