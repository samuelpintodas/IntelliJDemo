
public class VecteurTrie {

	static int vector[];
	static int vector2[] = {2, 4, 5, 54, 63, 76, 99};
	static int nbrSearched;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		vector = VecteurTrie(100);
		System.out.print("[");
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
		System.out.print("] \n");
		
		nbrSearched = (int) (Math.random() * 99);
		
		System.out.println("Nombre recherch�:" + nbrSearched);
		
		rechercheDicho(vector, nbrSearched);
	}

	// G�n�re un vecteur tri�
	public static int[] VecteurTrie(int size) {

		int[] vector = new int[size];

		for (int i = 0; i < size; i++) {
			vector[i] = (int) (Math.random() * 99);
		}

		triInsertion(vector);

		return vector;
	}

	// Recherche dichotomique
	public static boolean rechercheDicho(int[] tab, int numSearched) {

		boolean present = false;
		int nbTests = 0;
		int m = tab.length/2;
		int a = 0;
		int b = tab.length;

		while (tab[m]!=numSearched && a != b){
		
		nbTests +=1;
		
		if (numSearched < tab[m]) {
			b = m;
		} else if (numSearched > tab[m]) {
			a = m;
		} else{
			present = true;
			System.err.println("Nbre de tests: " + nbTests + "(nbre trouv�)");
			return present;
		}
		m = (a + b) / 2;
		}
		
		System.err.println("Nbre de tests: " + nbTests + "(nbre absent du vecteur)");
		return present;
	}

	// ----------------------------------------------------------------------------------------
	// Methodes de tri
	// ----------------------------------------------------------------------------------------
	public static int[] triSelection(int[] tab) {
		System.out.println("Apr�s triSelection");

		for (int i = 0; i < tab.length; i++) {

			for (int j = i; j < tab.length; j++) {

				if (tab[i] > tab[j]) {
					int temp = tab[j];
					tab[j] = tab[i];
					tab[i] = temp;

				}

			}

		}
		return tab;
	}

	public static int[] triBulles(int[] tab) {
		System.out.println("Apr�s triBulles");

		int tabSize = tab.length;
		boolean tabInOrder = false;
		int temp;

		while (!tabInOrder) {

			tabInOrder = true;
			for (int i = 0; i < tabSize - 1; i++) {

				if (tab[i] > tab[i + 1]) {

					temp = tab[i];
					tab[i] = tab[i + 1];
					tab[i + 1] = temp;
					tabInOrder = false;

				}

			}

			tabSize--;
		}

		return tab;
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

}
