package ThreadsInterface;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//the thread is created here
		Thread t = new Thread(new Accept_clients(MySkServer));
		
		//starting the thread
		t.start();
		
		System.out.println("My threads are ready");
	}

}
