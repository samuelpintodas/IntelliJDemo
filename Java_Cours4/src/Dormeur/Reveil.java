package Dormeur;

public class Reveil implements Runnable {
	private Thread d;
	private long millis;

	public Reveil(Thread d, long millis) {
		this.d = d;
		this.millis = millis;
	}

	public void run() {
		try {
			Thread.sleep(millis);

			System.out.println("Reveil : Drriiiiiiiiiing");
			d.interrupt();

		} catch (InterruptedException e) {

			System.out.println("Reveil : Le réveil sonne !");
		}
	}
}
