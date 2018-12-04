package thred;

public class TestThread extends Thread
{
	public TestThread (String name)
	{
		super(name);
	}
	
	public void run()
	{
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j <10; j++) 
			{
				System.out.println(this.getName());
			}
		}
	}

}
