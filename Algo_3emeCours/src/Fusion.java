
public class Fusion {

	static int tab1[];
	static int tab2[];
	static int tab3[];

	public static void main(String[] args) {

		tab1 = vecteurTrie(5);
		tab2 = vecteurTrie(9);
		
		System.out.println("tab 1");
		tabDisplay(tab1);
		System.out.println("\ntab 2");
		tabDisplay(tab2);

		tab3 = tabFusion(tab1, tab2);


		System.out.println("\ntab 3");
		tabDisplay(tab3);
	}

	private static int[] tabFusion(int[] t1, int[] t2) {

		int indexToInsert = 0;
		int t3 [] = new int [t1.length + t2.length];
		int i = 0;
		int j = 0;
		

		while(i < t1.length && j < t2.length){
			
			if(t1[i] < t2[j]){
				t3[indexToInsert] = t1[i];
				i++;
				indexToInsert++;
			
			}else {
				t3[indexToInsert] = t2[j]; 
				j++;
				indexToInsert++;
			}
			
		}
		
		if(i < t1.length)
			for(indexToInsert = indexToInsert; indexToInsert < t3.length; i++, indexToInsert++){
				t3[indexToInsert] = t1[i];
			}
		else
			for(indexToInsert = indexToInsert; indexToInsert < t3.length; j++, indexToInsert++){
				t3[indexToInsert] = t2[j];
			}
		
		return t3;
	}

	private static void tabDisplay(int[] tab) {

		System.out.print("[");
		for (int i = 0; i < tab.length - 1; i++) {
			System.out.print(tab[i] + "\t");
		}
		System.out.print(tab[tab.length - 1]);
		System.out.print("] \n");

	}

	// Génère un vecteur trié
	public static int[] vecteurTrie(int size) {

		int[] tab = new int[size];

		for (int i = 0; i < size; i++) {
			tab[i] = (int) (Math.random() * 99);
		}

		triInsertion(tab);

		return tab;
	}

	// Méthode de tri par insertion
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
