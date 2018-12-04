package ThreadsSocketsDemo_Widmer;

public class DemoThreadSimple {

	public static class TestThread extends Thread {


		public TestThread(String name){
			super(name);
		}

		public void run(){
			try {
				for(int i = 0; i < 10; i++){
					System.out.println(this.getName() + ":" + i);
					Thread.sleep(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}       
		}
	}
	public static void main(String[] args) {

		TestThread t = new TestThread("A");
		TestThread t2 = new TestThread("  B");
		t2.start();
		t.start();
	}
}