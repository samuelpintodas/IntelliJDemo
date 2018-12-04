
public class HuitReines {

	static int tab [] = new int [8];
	static int ligne;
	static int colonne = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fillTab(tab);
		placeHuitReines(colonne);
		
	}


	private static void placeHuitReines(int colonne) {
		
		if(colonne == 8){
			printTab(tab);
			return;
		}
		
		for(ligne = 0; ligne <9; ligne++)
			if(testMatch(colonne, ligne)){
				tab[colonne] = ligne;
				placeHuitReines(colonne+1);
				
			}	
		
	}


	private static void printTab(int[] t) {
		
		System.out.print("[ ");
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + " ");
		}
		System.out.print("]");
		
	}


	private static void fillTab(int[] t) {
		
		for (int i = 0; i < t.length; i++) {
			t[i] = -1;
		}
		
	}
	
	private static boolean testMatch(int ligne, int colonne){
		System.out.println("On rentre dans testMatch");
		System.out.println("Colonne = " + colonne);
		
		for(int i = 0; i < tab.length; i++){
			// test pour la colonne
			if(colonne == tab[i])
				return false;
			
			// test pour la ligne
			if(tab[i] != -1 && ligne == i)
				return false;
			
			// test pour la diagonale
			for(int j = 0; j<tab.length; j++){
				if(tab[j] != colonne && j !=ligne && tab[j]!=-1)
					return false;
			}
			
		}
		
		return true;
	}

}
