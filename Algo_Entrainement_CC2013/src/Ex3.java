
public class Ex3 {
	
	static int[] tab = {12, 3,	9, 2, 10, 8, 15};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(tri(tab, tab.length-1));
		System.out.println("est la mediane du tableau ");
		printTab(tab);
		
		
	}
	
	public static int tri(int[] tab, int taille)
	{
		/*clause de finitude*/
		if(taille==1) {
			int indexMediane = 0+tab.length/2;
			int mediane = tab[indexMediane];
			return mediane;
		}
		
		/*pas récursif*/
		for (int j = 0; j < taille; j++)
		{
			int posAct = j ;
			int posSuiv = j+1 ;
			
			if(tab[posAct]>tab[posSuiv])
			{
				int temp = tab[posAct] ;
				tab[posAct] = tab[posSuiv] ;
				tab[posSuiv] = temp ;
			}

		}
		
		return tri(tab, taille-1);
	}
	
	private static void printTab(int [] tab)
	{
		System.out.print("[");
		for(int l = 0; l<tab.length; l++)
			System.out.print(tab[l] + " ");
		
		System.out.print("]\n");
			
	}

}
