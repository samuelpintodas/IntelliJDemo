import java.util.Scanner;

public class Ex2 {
	
	static int number;
	static String stringNumber="";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.println("Insérez un entier");
		number = input.nextInt();
		
		System.out.println("Entier converti:");
		System.out.println(convertToString(stringNumber, number));
		
		
	}

	private static String convertToString(String stnum, int num) {
		
		// clause de finitude
		if(num == 0)
			return stnum;
		
		
		return convertToString(stringNumber=num%10 + stnum, num/10);
		
	}

}
