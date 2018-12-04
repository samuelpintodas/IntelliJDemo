
public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fibonacci(5));
	}

	private static int fibonacci(int n) {
		// TODO Auto-generated method stub
		
		
		//CLAUSES DE FINITUDES
		
		//1er plus petit terme que je connais
		if(n==0){
			return 0;
		}
		
		//2eme plus petit terme que je connais
		if(n==1){
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
