

public class Compteur implements Runnable {
	
	private int value;

	public Compteur(int i) {

		value = i ;

	}

	public static void main(String[] args) {
		

		Thread t1 = new Thread(new Compteur(5));
		Thread t2 = new Thread(new Compteur(10));
		Thread t3 = new Thread(new Compteur(15));
		Thread t4 = new Thread(new Compteur(20));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

	@Override
	public void run() {
		
		System.out.println("Début du comptage");
		for (int i = 0; i < value; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
	}

}
