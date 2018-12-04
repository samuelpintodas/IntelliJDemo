package iteratives;

import java.util.Scanner;

public class dichotomique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tab = { 1, 2, 45, 25, 49, 64, 12, 2, 1, 0, 19, 96 };
		int nbrSearched;
		Scanner input = new Scanner(System.in);
		System.out.println("Quel nombre cherchez-vous?");
		nbrSearched = input.nextInt();
		triInsertion(tab);
		printTab(tab);
		rechercheDichotomique(tab, nbrSearched);
		

	}

	public static void triInsertion(int vecteur[]) {
	

		int a, b;
		for (a = 0; a < vecteur.length; a++) {
			int chiffre = vecteur[a];
			for (b = a; b > 0 && vecteur[b - 1] > chiffre; b--) {
				vecteur[b] = vecteur[b - 1];

			}
			vecteur[b] = chiffre;

		}

	}

	public static int rechercheDichotomique(int[] tab, int valeur) {

		System.out.println("Nombre recherché: " + valeur);

		int gauche = 0;
		int droite = tab.length - 1;
		int milieu;

		while (gauche <= droite) {
			// affichePortion(gauche, droite);

			milieu = (gauche + droite) / 2;

			if (tab[milieu] == valeur) {
				System.out.println("Index du nombre recherché: " + milieu);
				return milieu;
			}

			if (tab[milieu] > valeur)
				droite = milieu - 1;
			else
				gauche = milieu + 1;
		}
		System.out.println("Nombre absent du tableau");
		return -1; // pour que la boucle s'arrête
	}

	private static void printTab(int[] tab) {
		System.out.print("[");
		for (int l = 0; l < tab.length; l++)
			System.out.print(tab[l] + " ");

		System.out.print("]\n");

	}
}
