package Sudoku;

public class GrilleSudoku{
    int tab[][];


    public GrilleSudoku(int[][] mat) {
        tab = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                tab[i][j] = mat[i][j];
    }

    public void affiche()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
                System.out.print(tab[i][j]+"  ");
            System.out.println() ;
        }
        System.out.println() ;
        System.out.println() ;
    }



    public void sudoku() {
        int[] nouvelleCase = chercheCaseSuivante(0, -1) ;
        System.out.println(nouvelleCase[0]+ " " + nouvelleCase[1]);
        sudoku(nouvelleCase[0], nouvelleCase[1]);
    }



    private void sudoku(int ligne, int colonne)
    {
        if (ligne == 9)
        {
            affiche();
            return;
        }

        for (int chiffre = 1; chiffre <= 9; chiffre++)
            if (possibleMettreChiffre(chiffre, ligne, colonne))
            {
                tab[ligne][colonne] = chiffre ;
                int[] nouvelleCase = chercheCaseSuivante(ligne, colonne) ;
                sudoku(nouvelleCase[0], nouvelleCase[1]);
                tab[ligne][colonne] = 0 ;
            }
    }






    public boolean possibleMettreChiffre(int chiffre, int ligne, int colonne)
    {
        for (int i = 0; i < 9; i++) //test colonne
            if (tab[i][colonne] == chiffre)
                return false;

        for (int j = 0; j < 9; j++) //test ligne
            if (tab[ligne][j] == chiffre)
                return false;

        for (int i = 0; i < 3; i++) // test du carr�
            for (int j = 0; j < 3; j++)
                if (tab[ligne / 3 * 3 + i][colonne / 3 * 3 + j] == chiffre)
                    return false;

        return true;
    }

    //retour de la case sous format de tableau
    public int[] chercheCaseSuivante(int ligne, int colonne)
    {
        int nouvelleLigne = ligne ;
        int nouvelleColonne = colonne ;
        do{
            nouvelleLigne = nouvelleLigne+(nouvelleColonne+1)/9 ;
            nouvelleColonne = (nouvelleColonne+1)%9 ;
        }
        while (nouvelleLigne != 9 && tab[nouvelleLigne][nouvelleColonne] > 0);

        int caseSuivante[] = {nouvelleLigne, nouvelleColonne};

        return caseSuivante;
    }
}

