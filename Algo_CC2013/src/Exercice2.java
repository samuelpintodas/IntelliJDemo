
public class Exercice2 {

	public String  intToString(int num) {
	    return intToString(num, "");
	}

	private String intToString(int num, String rep ) {
	    if (num == 0) {
	    	return rep;
	    }
	            
	    return intToString(num/10, rep = num % 10 + rep);
	}
	
}
