
public class AlgoTri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] tab = { 45, 24, 12, 41, 56, 74, 9, 11, 2, 33 };

		// affichage du tableau de base
		System.out.println("Avant tri");
		for (int k = 0; k < tab.length; k++) {
			System.out.print(tab[k] + " - ");
		}
		System.out.println("\n");
		
		

		// test de la méthode tri selection
		triSelection(tab);
		for (int k = 0; k < tab.length; k++) {
			System.out.print(tab[k] + " - ");
		}
		System.out.println("\n");
		
		

		// test de la méthode tri bulle
		int[] tab1 = { 45, 24, 12, 41, 56, 74, 9, 11, 2, 33 };
		triBulles(tab1);
		for (int k = 0; k < tab1.length; k++) {
			System.out.print(tab1[k] + " - ");
		}
		System.out.println("\n");
		
		
		// test de la méthode tri bulle
		int[] tab2 = { 45, 24, 12, 41, 56, 74, 9, 11, 2, 33 };
		triInsertion(tab2);
		for (int k = 0; k < tab2.length; k++) {
			System.out.print(tab2[k] + " - ");
		}

	}

	public static int[] triSelection(int[] tab) {
		System.out.println("Après triSelection");
		int iteration=0;
		int echange=0;
		for (int i = 0; i < tab.length; i++) {
			
			for (int j = i; j < tab.length; j++) {
				iteration++;
				
				if (tab[i] > tab[j]) {
					echange++;
					int temp = tab[j];
					tab[j] = tab[i];
					tab[i] = temp;

				}

			}
			
		}

		System.out.println("nb iteration : "+iteration);
		System.out.println("nb echange : "+echange);
		return tab;
	}

	public static int[] triBulles(int[] tab) {
		System.out.println("Après triBulles");
		
		int tabSize = tab.length;
		boolean tabInOrder = false;
		int temp;
		int iteration=0;
		int echange=0;

		while (!tabInOrder) {
			
			tabInOrder = true;
			for (int i = 0; i < tabSize - 1; i++) {
				iteration++;
				
				if (tab[i] > tab[i + 1]) {
					echange++;
					temp = tab[i];
					tab[i] = tab[i+1];
					tab[i+1] = temp;
					tabInOrder = false;
				
				}

			}
			
			tabSize --;
		}
		System.out.println("nb iteration : "+iteration);
		System.out.println("nb echange : "+echange);

		return tab;
	}
	

	public static void triInsertion(int vecteur[]) {
		System.out.println("Après triInsertion");
		
		int a,b;
		int iteration=0;
		for(a=0;a<vecteur.length;a++) {
			int chiffre=vecteur[a];
			for(b=a;b>0 && vecteur[b-1]> chiffre;b--) {
				vecteur[b]=vecteur[b-1];
				iteration++;
			}
			vecteur[b]=chiffre;
			
		}
		System.out.println("nb iteration : "+iteration);
	}
		
		
		
	
	
}
