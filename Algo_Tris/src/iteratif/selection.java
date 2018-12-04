package iteratif;

public class selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] tab = {1,2,45,25,49,64,12,2,1,0,19,96};
		printTab(tab);
		triSelection(tab);
		printTab(tab);
		
	}
	
	public static void triSelection(int[] tab) {
		System.out.println("Après triSelection");

		for (int i = 0; i < tab.length; i++) {

			for (int j = i; j < tab.length; j++) {

				if (tab[i] > tab[j]) {
					int temp = tab[j];
					tab[j] = tab[i];
					tab[i] = temp;

				}

			}

		}
		
	}
	
	private static void printTab(int [] tab)
	{
		System.out.print("[");
		for(int l = 0; l<tab.length; l++)
			System.out.print(tab[l] + " ");
		
		System.out.print("]\n");
			
	}

}
