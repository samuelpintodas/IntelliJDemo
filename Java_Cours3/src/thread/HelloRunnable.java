package thread;

public class HelloRunnable implements Runnable {
	public void run() {
		
		System.out.println("Hello from a thread!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(new HelloRunnable());
		
		t.start();
		t.join();
		
		System.out.println(".end");

	}

}
