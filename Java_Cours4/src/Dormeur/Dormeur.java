package Dormeur;

public class Dormeur implements Runnable {

	public void run() {
		try {
			System.out.println("Dormeur : Je m'endore.");

			while (true) {
				System.out.println("Dormeur : rrrh, rrrh");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Dormeur : Le réveil sonne !");
			System.out.println("Dormeur : Je me réveille.");
		}
	}
}
