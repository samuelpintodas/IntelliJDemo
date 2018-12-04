package pieces;

public class ComptePieces {

    int nbSolutions;
    int[] pieces = {50, 20, 10, 5};
    int[] sol = new int[20];

    public ComptePieces()
    {
        change(0, 0, 0);
    }


    //Peut-on mettre la piece en question?
    private boolean piecePossible(int piece, int montant)
    {
        if((piece+montant)<=100)
            return true;

        return false;
    }

    private void change(int somme, int debut, int position)
    {
        if(somme == 100){
            ++nbSolutions;
            affichePiece(sol);
            return;
        }



        for(int i = debut; i<4; i++)
        {
            if(piecePossible(pieces[i],somme))
            {
                sol[position] = pieces[i];
                change(somme+pieces[i], i, position+1);
                sol[position] = 0;
            }
        }
    }

    private void affichePiece(int[] tab)
    {
        for (int i = 0; i<tab.length; i++)
        {
            System.out.print(tab[i] + " ");
        }
        System.out.print("\n");
    }
}
