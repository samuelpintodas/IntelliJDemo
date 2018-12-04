package iteratif;

public class insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] tab = {1,2,45,25,49,64,12,2,1,0,19,96};
		printTab(tab);
		triInsertion(tab);
		printTab(tab);
		
	}
	
	public static void triInsertion(int vecteur[]) {
		System.out.println("Après triInsertion");

		int a, b;
		for (a = 0; a < vecteur.length; a++) {
			int chiffre = vecteur[a];
			for (b = a; b > 0 && vecteur[b - 1] > chiffre; b--) {
				vecteur[b] = vecteur[b - 1];

			}
			vecteur[b] = chiffre;

		}

	}
	
	private static void printTab(int [] tab)
	{
		System.out.print("[");
		for(int l = 0; l<tab.length; l++)
			System.out.print(tab[l] + " ");
		
		System.out.print("]\n");
			
	}

}
