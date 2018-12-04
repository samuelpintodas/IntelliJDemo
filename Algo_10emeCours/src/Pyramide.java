public class Pyramide {
	int tab[];

	boolean marque[];

	static int depart[] = { 0, 4, 13, 32 };

	static int fin[] = { 3, 9, 31, 99 };

	int cpt;

	public Pyramide() {
		tab = new int[4];
		marque = new boolean[10];
		cpt = 0;
	}

	public void pyramide() {
		pyramide(0);
		System.out.print(cpt + &quot; solutions&quot;);
	}

	private void pyramide(int n) {
		if (n == 4) {
			affiche();
			++cpt;
			return;
		}

		for (int i = depart[n]; i &lt;= fin[n]; i++) {
			int carre = i * i;

			if (possibleMettreCarre(carre, n)) {
				fixe(carre, true, n);
				tab[n] = carre;
				pyramide(n + 1);
				fixe(carre, false, n);
			}
		}
	}

	private boolean possibleMettreCarre(int nombre, int n) {
		// on fait ici une copie du vecteur
		int chiffre;
		boolean copie[] = new boolean[10];

		for (int i = 0; i &lt; 10; i++)
			copie[i] = marque[i];

		for (int i = 0; i &lt;= n; i++) { // n+1 = nombre de chiffres
										// significatifs
			chiffre = nombre % 10;
			if (copie[chiffre])
				return false;
			copie[chiffre] = true;
			nombre /= 10;
		}

		return true;
	}

	public void affiche() {
		for (int i = 0; i &lt; 4; i++)
			System.out.println(tab[i]);

		System.out.println();
	}

	private void fixe(int nombre, boolean valeur, int n) {
		for (int i = 0; i &lt;= n; i++) {
			marque[nombre % 10] = valeur;
			nombre /= 10;
		}
	}
}

