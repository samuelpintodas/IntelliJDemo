
public class Ex1 {
	
	static int [] tab = new int[15];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		rempliTab(tab);
		printTab(tab);
		triInsertionR(tab, tab.length);
		printTab(tab);
		
	}
	
	public static void triInsertionR(int tab[], int taille) {
		   if (taille > 1) {
		      triInsertionR(tab, taille - 1);
		      insertionR(tab, taille - 1, tab[taille - 1]);
		   }
		}
	
	public static void insertionR(int[] tab, int taille, int e) {
		   // taille =  nombre d'éléments de t
		   // e = élément à insérer
		   if ((taille == 0) || (e >= tab[taille - 1]))
		      tab[taille] = e;
		   else {
		      tab[taille] = tab[taille - 1];
		      insertionR(tab, taille - 1, e);
		   }
		}

	public static int[] rempliTab(int [] tab) 
	{
		int alea;
		for (int i=0; i<tab.length; i++) 
		{
			alea = (int) (Math.random()*50); 
			tab[i] = alea; 
		}
		return tab; 
	}
	
	private static void printTab(int [] tab)
	{
		System.out.print("[");
		for(int l = 0; l<tab.length; l++)
			System.out.print(tab[l] + " ");
		
		System.out.print("]\n");
			
	}

}
