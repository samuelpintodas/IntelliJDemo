
public class Main {

	public static void main(String[] args) {
		
		//Exerice 1
		System.out.println("Exercice 1");
		Exercice1 ex1 = new Exercice1(5); 
		ex1.rempliTab(); 
		ex1.afficheTab();
		ex1.insertionRecur(5);
		System.out.println();
		ex1.afficheTab();
		
		//Exercice 2
		System.out.println("\n\nExercice 2");
		Exercice2 ex2 = new Exercice2(); 
		String test = ex2.intToString(123);
		System.out.println(test);
		
		//Exercice 3
		System.out.println("\n");
		

	}

}
