
public class Exercice3 {

	int[] vecteur; 
	boolean change = true;
	int i;
	int j;
	
	public int[][] triMatrice(int colonne, int[][] matrice) {
		
		while(change==true) {
		
			for(i=0; i<matrice.length-1; i++) 
			{
				change = false; 
			
				if(matrice[i][colonne] > matrice[i+1][colonne]) 
				{
					vecteur = imprimeVecteur(matrice, i);
					
					for (j = 0; j<matrice[0].length; j++) 
					{
						matrice[i][j] = matrice[i+1][j];
						matrice[i+1][j] = vecteur[j];
						
					}
					change = true;
				}
			}
		}
		
		return matrice;
	}
	
	public int[] imprimeVecteur(int[][] matrice, int ligne) {
		
		vecteur = new int[matrice.length];
		
		for(int i=0; i<matrice[0].length; i++) {
			vecteur[i] = matrice[ligne][i]; 
		}
		
		//afficheVecteur(vecteur);
		return vecteur;
	}
	
	public void affiche(int[][] matrice) {
		for(int i=0; i<matrice.length; i++) {
			for (int j=0; j<matrice.length; j++) {
				System.out.print(matrice[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public void afficheVecteur(int[] vecteur) {
		for (int i = 0; i < vecteur.length; i++) {
			System.out.print(vecteur[i]+"\t");
		}
		System.out.println();
	}
	
}
