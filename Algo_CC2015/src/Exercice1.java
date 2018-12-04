
public class Exercice1 {
	
	int nb; 
	String convert; 
	int nbZero = 0;
	char carac; 
	
	public Exercice1(int nb) 
	{
		this.nb = nb; 
		this.convert = Integer.toString(nb);
	}
	
	public int nbZero() {
		return nbZero(0); 
	}

	public int nbZero(int indice) 
	{	
		//Clause de finitude
		if(indice == convert.length()) 
		{
			return nbZero;
		}
		
		//Pas récursif 
		carac = convert.charAt(indice); 
		
		if(carac == '0') {
			nbZero += 1;
		}
		
		return nbZero(indice+1); 
	}
	
	public String toString(int nbZ) {
		return "Le nombre "+nb+" contient "+nbZ+" zéros.";
	}
	
}
