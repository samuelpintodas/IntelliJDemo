import Sudoku.GrilleSudoku;
import pieces.ComptePieces;

public class main
{
    static int [][]grille = {       {0, 0, 4, 	0, 0, 0, 	5, 0, 0},
                                    {0, 0, 3, 	2, 0, 6, 	9, 0, 0},
                                    {6, 0, 0, 	0, 5, 0, 	0, 0, 3},

                                    {0, 4, 1, 	7, 0, 9, 	3, 5, 0},
                                    {0, 0, 0, 	0, 0, 0, 	0, 0, 0},
                                    {0, 5, 6, 	3, 0, 2, 	8, 7, 0},

                                    {8, 0, 0, 	0, 3, 0, 	0, 0, 7},
                                    {0, 0, 2, 	9, 0, 7, 	1, 0, 0},
                                    {0, 0, 7, 	0, 0, 0, 	6, 0, 0}} ;

    public static void main(String[] args)
    {


        GrilleSudoku sudoku = new GrilleSudoku(grille);

        System.out.println("EX.1 - GRILLE DE SUDOKU");
        sudoku.affiche();
        System.out.println("\n");
        sudoku.sudoku();


        System.out.println("\n\nEX.2 - COMPTEPIECES");
        ComptePieces pieces = new ComptePieces();

    }

}
