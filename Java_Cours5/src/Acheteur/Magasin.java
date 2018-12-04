package Acheteur;

public class Magasin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Sac s = new Sac();

		Thread marie = new Thread(new Acheteur(s, "Marie"));
		marie.start();
		
		Thread virginie = new Thread (new Acheteur(s, "Virginie"));
		virginie.start();
		
		marie.join();
		virginie.join();
		
		System.out.println("Sac : " + s.getSize());
		
		
	}

	
}
