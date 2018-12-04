package ThreadsSocketsDemo_Widmer;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

public class ServerTestRunnable {

	public static void main(String[] zero){
		Socket srvSocket = null ;
		InetAddress localAddress = null;
		ServerSocket mySkServer;
		String interfaceName = "eth1";
		Thread t; 
		
		try {
			NetworkInterface ni = NetworkInterface.getByName(interfaceName);
	        Enumeration<InetAddress> inetAddresses =  ni.getInetAddresses();
			while(inetAddresses.hasMoreElements()) {
	            InetAddress ia = inetAddresses.nextElement();
	            
	            if(!ia.isLinkLocalAddress()) {
	               if(!ia.isLoopbackAddress()) {
	            	   System.out.println(ni.getName() + "->IP: " + ia.getHostAddress());
	            	   localAddress = ia;
	               }
	            }   
            }
			
			//Warning : the backlog value (2nd parameter is handled by the implementation
			mySkServer = new ServerSocket(45007,10,localAddress);
			System.out.println("Default Timeout :" + mySkServer.getSoTimeout());
			System.out.println("Used IpAddress :" + mySkServer.getInetAddress());
			System.out.println("Listening to Port :" + mySkServer.getLocalPort());

			//the thread is created here	
			t = new Thread(new AcceptClient(mySkServer));

			//starting the thread
			t.start();

			System.out.println("My threads are ready");

		} catch (IOException e) {

			e.printStackTrace();
		}
		}
}
