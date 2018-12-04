
public class Palindrome {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pal = "kayak";
		
		int debut = 0;
		int fin = pal.length()-1;
		
		if((palindrome(pal, debut, fin)) == false)
			System.out.println("Ce n'est pas un palindrome");
		else if((palindrome(pal, debut, fin)) == true)
			System.out.println("C'est un palindrome!");
			

	}
	
	public static boolean palindrome(String word, int debut, int fin){
		
		
		System.out.println("Index debut = " + debut + " Index fin = " + fin);
		System.out.println("Debut = " + word.charAt(debut) + " fin = " +  word.charAt(fin));
		
		
		if(debut == fin)
			return true;
		
	
		if(fin <= debut)
			return true;
		

		if(word.charAt(debut) == word.charAt(fin))
			return palindrome(word, debut+1, fin-1);	
			
		
		return false;
		
	}
	
	public static String reduction(String s){
		
		
		
		return s;
	}
		
}
