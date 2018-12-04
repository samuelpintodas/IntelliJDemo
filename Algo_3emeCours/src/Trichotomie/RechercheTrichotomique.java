package Trichotomie;

public class RechercheTrichotomique {

	
	int vecteur [];

	public RechercheTrichotomique() 
	{

		vecteur = new int [1000];

		for (int i = 0; i < vecteur.length; i++) 
		{

			vecteur[i] = (int)(Math.random()*1000+1);


		}

		monTri(vecteur, vecteur.length);

		displayTab();

	}
	
	public int searchTrichotomic(int target){

		int iDebut = 0;
		int iFin  = vecteur.length-1;
		int milieu1, milieu2;

		while(iDebut <= iFin){
			
			milieu1 = (2*iDebut + iFin)/3;
			milieu2 = (iDebut + 2*iFin)/3;

			if(target == vecteur[milieu1]){

				return milieu1;
			}
			if(target == vecteur[milieu2]){

				return milieu2;
			}
			if(target < vecteur[milieu1]){

				iFin = milieu1 - 1;

			}else if(target > vecteur[milieu2]){

				iDebut = milieu2 + 1;

			}else{

				iFin = milieu2 - 1;
				iDebut = milieu1 + 1;
			}
		}
		return -1;
	}
	
	private void displayTab()
	{
		for (int i = 0; i < vecteur.length; i++) {
			
			System.out.println(vecteur[i]);
		}
	}
	
	private int max(int tab[], int taille)
	{
		// on considère que le plus grand élément est le premier
		int i=0, indice_max=0;

		while(i < taille)
		{
			if(tab[i] > tab[indice_max])
				indice_max = i;
			i++;
		}

		return indice_max;
	}


	//on va échanger les deux nombres 

	void echanger(int tab[], int x, int y)
	{
		int tmp;

		tmp = tab[x];
		tab[x] = tab[y];
		tab[y] = tmp;
	}


	//on va faire le tri général en fonction de la taille du tableau

	void monTri(int tab[], int taille)
	{
		int indice_max;


		for(; taille > 1 ; taille--) 
		{
			indice_max = max(tab, taille);

			echanger(tab, taille-1, indice_max);
		}



	}
}
