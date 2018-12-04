package Dormeur;

public class ThreadInterruptedDormeur {	
	
	public static void main(String [] args) {
	
	Thread bob = new Thread(new Dormeur()) ;		
	
	new Thread(new Reveil(bob, 10000)).start() ;	
	
	bob.start();
	
}

}
