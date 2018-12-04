
public class factorielle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.out.println(fact(5));
	}

	private static long fact(int n) {
		
		
		
		//Clause de finitude
		if(n == 0){			
			return 1;
		}
		
		
		//pas récursif
		return n* fact(n-1);
	}

}
