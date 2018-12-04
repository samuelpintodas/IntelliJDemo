
public class CC_Ex3 {
	
	static int matrix [][];
	static int matrixSize;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CC_Ex3 mat = new CC_Ex3(6,7);
		matrixSize = matrix[0].length;
		afficheMatrice(matrix);
		trieMatrice(4,5);
		System.out.println("\nMatrice une fois triee :\n");
		afficheMatrice(matrix);
		
	}
	
	// Constructeur de la matrice
	public CC_Ex3(int n, int m){
		
		matrix = new int [n][m];
		
		for (n = 0; n < matrix.length; n++) {
			for(m = 0; m < matrix[0].length; m++){
				matrix[n][m] = (int) (Math.random()*10+1);
			}
		}
	}
	
	// methode de tri
	public static void trieMatrice(int col1, int col2) {
		
		matrixSize-=1;
		
		boolean matrixInOrder = false; // matrice ordonnee ou nom
		int act;
		int suiv;

		// Temps que la matrice n'est pas ordonnée
		while (!matrixInOrder) {

			matrixInOrder = true;
			for (int i = 0; i < matrixSize-1; i++) {
				act = i;
				suiv = i+1;
				
				// si matrix[act][col2] est supérieur à matrix[suiv][col2]
				if(matrix[act][col2] > matrix[suiv][col2]){
					inverse(act, suiv);	// on les inverse
					matrixInOrder = false; // on défini la matrice comme non-ordonnée
				}
				
				// idem pour avec la col1
				if (matrix[act][col1] > matrix[suiv][col1]) {
					inverse(act, suiv);
					matrixInOrder = false;
				}
		
			}
			
			matrixSize--;
		}

	}
	
	// méthode d'inversion des lignes
	private static void inverse(int a, int b){		
		
	int [] temp = matrix[a];
	matrix[a] = matrix[b];
	matrix[b] = temp;
	}
	
	// méthode d'affichage de la matrice
	public static void afficheMatrice(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
