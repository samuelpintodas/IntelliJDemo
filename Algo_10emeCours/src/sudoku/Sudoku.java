package sudoku;

import java.util.ArrayList;

public class Sudoku
{
	
	   static int [][]grille = {	{0, 0, 4, 	0, 0, 0, 	5, 0, 0},
  			 						{0, 0, 3, 	2, 0, 6, 	9, 0, 0},
  			 						{6, 0, 0, 	0, 5, 0, 	0, 0, 3},
  			 	
  			 						{0, 4, 1, 	7, 0, 9, 	3, 5, 0},
  			 						{0, 0, 0, 	0, 0, 0, 	0, 0, 0},
  			 						{0, 5, 6, 	3, 0, 2, 	8, 7, 0},
  			 	
  			 						{8, 0, 0, 	0, 3, 0, 	0, 0, 7},
  			 						{0, 0, 2, 	9, 0, 7, 	1, 0, 0},
  			 						{0, 0, 7, 	0, 0, 0, 	6, 0, 0}} ;

	
	public Sudoku ()
	{
		
		resolve(0, 0);
			
	}   
	   
	private void resolve(int row, int column)
	{
		
		if(row == 9)
		{
			return;
		}
		
		for(int chiffre = 1; chiffre <= 9; chiffre ++)
		{
			if(placementPossible(chiffre,row, column))
			{
			grille[row][column] = chiffre;	
			int [] nouvelleCase = chercheCaseSuivante(row, column);
			resolve(nouvelleCase[0], nouvelleCase[1]);
			grille[row][column] = 0;
			}
		}
		
	}
	
	private int[] chercheCaseSuivante(int row, int column)
	{
		
		do {
			column++;
			if(column == 9){
				column = 0;
				row++;
			}
			if(row == 9)
			{
				int caseSuivante[] = {9, 0};
				return caseSuivante;
			}

		}while(grille[row][column] > 0);

		int caseSuivante[] = {row, column};
		return caseSuivante;
	}
	
	// teste si le placement est possible
	private boolean placementPossible(int number, int row, int column)
	{
		
		ArrayList<Integer> miniMatrix = myMiniMatrix(row, column);
		ArrayList<Integer> rowNumbers = new ArrayList<Integer>();
		ArrayList<Integer> columnNumbers = new ArrayList<Integer>();
		
		for(int i = 0; i < 9; i++)
		{
			rowNumbers.add(grille[row][i]);
			columnNumbers.add(grille[i][column]);
		}
		
		if(	(!miniMatrix.contains(number)) && 
			(!rowNumbers.contains(number)) && 
			(!columnNumbers.contains(number)))
			return true;
		
		return false;
	}

	// retourne le contenu d'une mini-matrice correspondant � l'un des 9 carr�s du sudoku
	private ArrayList<Integer> myMiniMatrix(int row, int column)
	{
		ArrayList <Integer> numbers = new ArrayList<Integer>();
		int startRow = testLine(row);
		int startColumn = testLine(column);
		int lastRow = startRow + 2;
		int lastColumn = startColumn + 2;
		
		for(int i = startRow; i<=lastRow; i++)
		{
			for (int j = startColumn; j<=lastColumn; j ++)
			{
				numbers.add(grille[i][j]);
			}
		}
		
		return numbers;
	}
	
	// teste le d�but de la ligne/colonne d'une minimatrice
	private int testLine(int line)
	{
		
		if(line < 6)
		{
			if(line < 3)
				return 0;
			else
				return 3;
		}
		else
			return 6;
	}

	public static void main(String[] args)
	{

		Sudoku test = new Sudoku();
		System.out.println("test");
	}
	


}
