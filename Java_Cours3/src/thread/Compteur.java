package thread;

public class Compteur implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new Compteur());
		Thread t2 = new Thread(new Compteur());
		Thread t3 = new Thread(new Compteur());
		Thread t4 = new Thread(new Compteur());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Début du comptage");
		for (int i = 0; i < 5; i++) {
			
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
