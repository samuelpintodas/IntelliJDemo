
public class RechercheRecursive {

	static int tab[] = {1, 5, 7, 2, 17, 21, 38, 42, 67};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int minimum = rechercheMinimum(0, tab.length-1);
		
		System.out.println(minimum);

	}
	
	private static int rechercheMinimum (int debut, int fin){
		
		if (debut > fin){
			return -1;
		}
		
		// si on a un tableau de taille 1
		if (debut == fin)
			return tab[debut];
		
		int min1 = rechercheMinimum(debut, milieu(debut, fin));
		int min2 = rechercheMinimum(milieu(debut, fin)+1, fin);
		
		if(min1 < min2)
			return min1;
		
		else if (min2 < min1)
			return min2;
		
		else
			return 0;

	}
	
	private static int milieu(int debut, int fin){
		return (debut+fin)/2;
		
	}
	

}
