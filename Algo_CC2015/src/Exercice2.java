
public class Exercice2 {
	
	int resultat;
	int nbPassage = 0;
	
	public int expo(int x, int y) {
	
		nbPassage += 1;
		System.out.println(nbPassage);
		
		//Clause de finitude 
		if(y==0) {
			return 1; 
		}else if(y==1) {
			return x; 
		}
		
		//Pas récursif
		if(y%2==0) {
			return (int) (Math.pow(expo(x,y/2), 2));
		}
		
		return (int) (x*(Math.pow(expo(x, y/2),2)));

	}

}
