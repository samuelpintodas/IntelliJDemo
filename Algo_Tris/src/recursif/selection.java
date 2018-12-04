package recursif;

public class selection {

	public static void main(String[] args)
	{
		int[] vecteur = {1,2,45,25,49,64,12,2,1,0,19,96};
		printTab(vecteur) ;
		tri(vecteur, vecteur.length) ;
		System.out.println();
		printTab(vecteur);
	}

	public static void tri(int[] vecteur, int taille)
	{
		/*clause de finitude*/

		if(taille==1) return ;

		/*pas recursif*/

		//recherche max
		int nombreMax = vecteur[0] ;
		int indMax = 0 ;
		for (int j = 1; j < taille ; j++)
		{

			if(vecteur[j]>nombreMax)
			{
				nombreMax = vecteur[j] ;
				//indice du nombre max
				indMax = j ;
			}
		}

		//echange
		int temp = vecteur[taille-1] ;
		vecteur[taille-1] = vecteur[indMax] ;
		vecteur[indMax] = temp ;
		
		//tri(taille-1)
		tri(vecteur, taille-1) ;
	}

	private static void printTab(int [] tab)
	{
		System.out.print("[");
		for(int l = 0; l<tab.length; l++)
			System.out.print(tab[l] + " ");
		
		System.out.print("]\n");
			
	}


	
}
