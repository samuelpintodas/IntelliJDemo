import java.util.Scanner;

public class Ex2 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(exp(3,2));
	
	}

	private static int exp(int x, int y) {
		// TODO Auto-generated method stub
		
		if(y == 0)
			return 1;
		
		if(y == 1)
			return x;
		
		if(y%2 == 1)
			return x*exp(x, y/2)*exp(x, y/2);
		
		return exp(x, y/2)*exp(x,y/2);
		
		
	}




}
