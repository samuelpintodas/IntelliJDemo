
public class Exercice1 {
	
	int n; 
	int tab[]; 
	int cpt; 
	int tempo;
	
	public Exercice1(int n) 
	{
		this.n = n;
		tab = new int[n]; 
	}
	
	public void insertionRecur(int tailleTableau) 
	{
		//Si la taille du tableau est plus grande que 1 on la réduit
		if(tailleTableau > 1) {
			//On rappelle la méthode avec un tableau plus petit 
			insertionRecur(tailleTableau-1);
		}
		
		//On passe sur tout le tableau
		for(int i=0; i<tailleTableau; i++) {
			tempo = tab[i]; 
			cpt = i - 1; 
			
			while(cpt >= 0 && tab[cpt] > tempo) {
				tab[cpt + 1] = tab[cpt]; 
				cpt--;
			}
			
			tab[cpt + 1] = tempo; 
		}
		
	}
	
	public int[] rempliTab() 
	{
		int alea;
		for (int i=0; i<tab.length; i++) 
		{
			alea = (int) (Math.random()*50); 
			tab[i] = alea; 
		}
		return tab; 
	}
	
	public void afficheTab() 
	{
		for(int i=0; i<tab.length; i++) 
		{
			System.out.print(tab[i]+"\t");
		}
	}

}
