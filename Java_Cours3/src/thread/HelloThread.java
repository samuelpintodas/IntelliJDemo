package thread;

public class HelloThread extends Thread{

	public void run(){
		
		System.out.println("Hello from a thread!");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t = new HelloThread();
		
		t.start();
		
		System.out.println("end.");
		
		
	}

}
