public class bitsTab 
{
	public static void main(String[] args) 
	{
		int tab [] = new int [3];

		binaire(tab,0);

	}

	public static void binaire(int [] tab, int a)
	{
		if(a == tab.length)
		{
			affiche(tab);
			return;
		}
		
		for (int i = 0; i < 2; i++)
		{
			tab[a] = i;
			binaire(tab,a+1);
		}
	}

	public static void affiche(int tab[])
	{
		for (int i = 0; i < tab.length; i++) 
		{
			System.out.print(tab[i]+"\t");
		}

		System.out.println();
	}
}