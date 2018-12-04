
public class Test {

	public static void main(String[] args) {
		
		//Exercice 1
		System.out.println("Exercice 1");
		Exercice1 ex1 = new Exercice1(453080090); 
		int nbZero = ex1.nbZero();
		System.out.println(ex1.toString(nbZero));
		
		//Exercice 2
		System.out.println("\nExercice2");
		Exercice2 ex2 = new Exercice2();
		int resultat = ex2.expo(2, 10);
		System.out.println("Résultat : "+resultat);
		
		//Exercice 3
		System.out.println("\nExercice3");
		int[][] matrice = {{1,3,4,5},{3,9,6,2},{1,2,4,1},{7,3,4,3}};
		Exercice3 ex3 = new Exercice3(); 
		ex3.affiche(matrice);
		ex3.triMatrice(1, matrice);
		System.out.println();
		ex3.affiche(matrice);

	}

}
