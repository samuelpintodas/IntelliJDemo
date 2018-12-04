package Trichotomie;

public class MainRechercheTrichotomique {

	public static void main(String[] args)
	{

		RechercheTrichotomique rTricho = new RechercheTrichotomique();
		
		int resultat = rTricho.searchTrichotomic(45);
		
		
		System.out.println(resultat);
		
	}

}
