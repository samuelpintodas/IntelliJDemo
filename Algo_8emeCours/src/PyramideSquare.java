
public class PyramideSquare {

	static int [] pyramide = new int [4];
	// bornes
	static int depart[] = 	{0,4,13,32};
	static int fin [] = 	{3, 9, 31, 99};
	static boolean presence [] = new boolean[10];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		affichagePyramide(pyramide);
		
	}

	private static void affichagePyramide(int[] pyramide) {
		
		for(int i = 0; i<pyramide.length; i++){
			System.out.println(pyramide[i]);
		}
		
	}

	private static void PyramideSquare(int index) {
		
		int number = 0;
		
		if(index == pyramide.length){
			affichagePyramide(pyramide);
			return;
		}

		for(int i = 0; i>= depart[index] && i<=fin[index]; i++)
			number = i*i;
		if(validateNumber(pyramide, index)){
			pyramide[index] = number;
			PyramideSquare(index+1);
		}
	}

	private static boolean validateNumber(int[] pyramide, int index) {


		if(perfectSquare(pyramide[index]) && onlyOneTime(pyramide, index)){
			presence[pyramide[index]] = true;
			return true;
		}
		
		return false;
	}

	private static boolean onlyOneTime(int[] pyramide, int index) {

		String numbers = Integer.toString(pyramide[index]);
		
		for (int i = 0; i < numbers.length(); i++) {
			for(int j = 0; j<presence.length; j++)
				if(presence[numbers.indexOf(i)])
					return false;
		}
		
		return true;
	}

	private static boolean perfectSquare(int number) {
		
		double nDouble = (double)(number);
		
		if(Math.sqrt(nDouble) % 1 == 0)
			return true;
		
		return false;
	}
	
	

}
