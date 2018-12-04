
public class Ex3 {
	
	static int[][] tab = {	{1, 3, 4, 5},
							{3, 9, 6, 2},
							{1, 2, 4, 1},
							{7, 3, 4, 3}};

	static int taille = tab[0].length;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		affiche(tab);
		triMatrices(tab, taille, 1);
		affiche(tab);
		
		
	}
	
	public static void triMatrices(int[][] tab, int taille,  int index) {
		System.out.println("Après triBulles");

		/*clause de finitude*/
		if(taille==1) 
			return ;
		
		/*pas récursif*/
		for (int j = 0; j < taille-1; j++)
		{
			int posAct = j ;
			int posSuiv = j+1 ;
			
			if(tab[posAct][index]>tab[posSuiv][index])
			{
				inverse(j, j+1);
			}

		}
		
		triMatrices(tab, taille-1, index) ;

	}
	
	private static void inverse(int a, int b){		
	
	int [] temp = tab[a];
	tab[a] = tab[b];
	tab[b] = temp;
				
	}
	
	private static void printTab(int [] tab)
	{
		System.out.print("[");
		for(int l = 0; l<tab.length; l++)
			System.out.print(tab[l] + " ");
		
		System.out.print("]\n");
			
	}
	
	public static void affiche(int[][] matrice) {
		for(int i=0; i<matrice.length; i++) {
			for (int j=0; j<matrice.length; j++) {
				System.out.print(matrice[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
