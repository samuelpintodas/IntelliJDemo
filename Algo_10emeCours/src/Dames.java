public class Dames {
	private int[] tab;
	int cpt ;

	// constructeur
	public Dames() {
		tab = new int[9];
	}

		
	// méthodes
	private boolean possibleMettreDame(int colonne, int ligne) {
		for (int i = 1; i < colonne; i++) {
			if (tab[i] == ligne)
				return false;

			if (colonne - i == Math.abs(ligne - tab[i]))
				return false;
		}
		return true;
	}

	public void affiche() {
		System.out.print(cpt + " : ");
		for (int i = 1; i < 9; i++)
			System.out.print(tab[i] + " ");

		System.out.println();
		++cpt ;
	}
	
	public void toutesLesSolutions() {
		cpt = 1 ;
		poseDame(1);
	}

	
	
	private void poseDame(int colonne) {
		if (colonne == 9) {
			affiche() ;
			return;
		}

		for (int ligne = 1; ligne < 9; ligne++)
			if (possibleMettreDame(colonne, ligne)) {
				tab[colonne] = ligne;
				poseDame(colonne + 1);
			}
	}

	
}	
	
	
	
	
	
	
	
	
	
