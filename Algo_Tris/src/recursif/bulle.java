/**
 * tri_bulle_recursif - Test.java
 * Author : Jonathan Schnyder
 * Created : 23 oct. 2017
 */

package recursif;

public class bulle
{
	public static void main(String[] args)
	{
		int[] vecteur = {1,2,45,25,49,64,12,2,1,0,19,96};
		printTab(vecteur) ;
		//vu qu'on compare toujours 2 positions côte à côte, la dernière comparaison est 
		//l'avant dernière comparaison avec la dernière position
		tri(vecteur, vecteur.length-1) ;
		System.out.println();
		printTab(vecteur);
	}
	
	public static void tri(int[] vecteur, int taille)
	{
		/*clause de finitude*/
		if(taille==1) 
			return ;
		
		/*pas récursif*/
		for (int j = 0; j < taille; j++)
		{
			int posAct = j ;
			int posSuiv = j+1 ;
			
			if(vecteur[posAct]>vecteur[posSuiv])
			{
				int temp = vecteur[posAct] ;
				vecteur[posAct] = vecteur[posSuiv] ;
				vecteur[posSuiv] = temp ;
			}

		}
		
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

