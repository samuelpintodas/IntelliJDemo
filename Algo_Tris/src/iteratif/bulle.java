package iteratif;

public class bulle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] tab = {1,2,45,25,49,64,12,2,1,0,19,96};
		printTab(tab);
		triBulles(tab);
		printTab(tab);
		
	}
	
	public static void triBulles(int[] tab) {
		System.out.println("Après triBulles");

		int tabSize = tab.length;
		boolean tabInOrder = false;
		int temp;

		while (!tabInOrder) {

			tabInOrder = true;
			for (int i = 0; i < tabSize - 1; i++) {

				if (tab[i] > tab[i + 1]) {

					temp = tab[i];
					tab[i] = tab[i + 1];
					tab[i + 1] = temp;
					tabInOrder = false;

				}

			}

			tabSize--;
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
