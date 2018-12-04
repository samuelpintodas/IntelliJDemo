
public class Permutation {
	
	static char tab[];

	public static void main(String[] args) 
	{
		
		Permutation test = new Permutation(3);
		
		test.permute();
	}
	
	public Permutation (int n)
	{	
		tab = new char[n];
		
		for(int i = 0; i<n; i++)
			tab[i] = (char)('A' + i);
		
	}
	
	public void permute()
	{
		permute(0, tab.length-1);
	}
	
	
	private static void permute(int depart, int fin)
	{
		
		if(depart == fin){
			affiche();
			return;
		}

			
		//pas récursif
		for(int i = depart ; i<= fin ; i++){
			echange(depart, i);
			permute(depart+1, fin);
			echange(depart, i);
		}
		
		return;
		
	}
	
	public static void echange(int i, int j)
	{
		char temp = tab[i];
		tab[i] = tab[j];
		tab[j] = temp;
	}

	private static void affiche() {
		
		for(int i = 0; i<tab.length; i++){
			System.out.print(tab[i] + " ");
		}
		System.out.println();
		
	}
		

}
