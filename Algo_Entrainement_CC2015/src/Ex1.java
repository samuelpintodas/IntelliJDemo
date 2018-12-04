import java.util.Scanner;

public class Ex1 {
	
	static int number;
	static int cptZero = 0;
	static int index = 0;
	static String stNumber = "";
	static char charac;
	static Scanner input = new Scanner(System.in);


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Saisissez votre nombre");
		number = input.nextInt();
		
		stNumber = Integer.toString(number);
		
		System.out.println("Nombre de zeros dans " + number + " : " + countZero(index));
	}

	private static int countZero(int index) {
	
	
	if(index == stNumber.length())
		return cptZero;
	
		
	charac = stNumber.charAt(index);
		
		if(charac == '0'){
			cptZero+=1;
			return countZero(index+=1);
		}
		
		else{
			return countZero(index+1);
		}
			
		
	}
	

}
