
public class CC_Ex2 {

	static int cptAppel = 0;
	static int pc1 = 0;
	static int pc2 = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Ex2 - a)");
		System.out.println(puissance(2,10));

		
		System.out.println("\n-------------------------------------------------------------");
		System.out.println("Appels à la méthode");
		System.out.println("Total: " + (cptAppel+pc1+pc2));
		System.out.println("Passages dans la clause 'if(y==0)' : " + pc1);
		System.out.println("Passages dans la clause 'if(y==1)' : " +pc2);
		System.out.println("Appels sans passage dans les clauses de finitude : " + cptAppel);
		
		System.out.println("\n-------------------------------------------------------------");
		System.out.println("Ex2 - c)");
		System.out.println(puissanceOpti(2,10));
	
	}

	// Puissance selon ex2 - a)
	private static int puissance(int x, int y) {
		// TODO Auto-generated method stub
		
		//Clause de finitude 
		if(y==0) {
			pc1+=1;
			return 1; 
		}
			
		if(y==1) {
			pc2+=1;
			return x; 
		}
		
		
		
		cptAppel +=1;
		
		
		if(y%2 == 1)
			return x*puissance(x, y/2)*puissance(x, y/2);
		
		
		return puissance(x, y/2)*puissance(x,y/2);
		
		
	}
	
	//Puissance selon ex2 - c)
	public static int puissanceOpti(int x, int y) {

		//Clause de finitude 
		if(y==0) 
			return 1; 
			
		if(y==1) 
			return x; 
		
		
		//Pas récursif
		if(y%2==0) 
			return (int) (Math.pow(puissanceOpti(x,y/2), 2));
		
		
		return (int) (x*(Math.pow(puissanceOpti(x, y/2),2)));

	}
	





}