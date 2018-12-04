
public class QuickSort
{

	static int[] tab = { 53, 27, 18, 71, 51, 31, 84, 5, 46, 91, 60, 99 };

	public static void main(String[] args)
	{
		displayTab();
		qSort(0, tab.length - 1);
		displayTab();
	}

	private static void qSort(int g, int d) // g et d délimitent les bornes du tableau
	{
		// i et j délimitent les parties du tableau sur lesquelles on travaille
		int i;
		int j;
		int pivot;

		// clause de finitude
		if (g >= d)
			return;

		pivot = tab[g];
		i = g + 1;
		j = d;

		while (i <= j)
		{
			while (i <= d && tab[i] <= pivot)
				++i;
			while (tab[j] > pivot)
				--j;

			if (i < j)
			{
				exchangeNumbers(i, j);
				i++;
				j--;
			}
		}

		// mise en place du pivot
		exchangeNumbers(g, j);

		// pas récursif
		qSort(g, j - 1);
		qSort(j + 1, d); // ou qSort(i, d)

	}

	private static void exchangeNumbers(int a, int b)
	{
		int temp = tab[a];
		tab[a] = tab[b];
		tab[b] = temp;
	}

	private static void displayTab()
	{
		System.out.print("[");
		for (int i = 0; i < tab.length; i++)
		{
			System.out.print(tab[i] + " ");
		}
		System.out.print("] \n");
	}

}
