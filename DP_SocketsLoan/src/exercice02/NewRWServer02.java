package exercice02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.PrintWriter;
public class NewRWServer02 {
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException {

		Socket srvSocket = null ;
		InetAddress localAddress = null;
		ServerSocket mySkServer;
//		PrintWriter pout;
		BufferedReader buffin;
		int i =0;
		String interfaceName = "eth1";

		try {

			NetworkInterface ni = NetworkInterface.getByName(interfaceName);
	        Enumeration<InetAddress> inetAddresses =  ni.getInetAddresses();
			while(inetAddresses.hasMoreElements()) {
	            InetAddress ia = inetAddresses.nextElement();
	            
	            if(!ia.isLinkLocalAddress()) 
	            {
	               if(!ia.isLoopbackAddress()) 
	               {
	            	   System.out.println(ni.getName() + "->IP: " + ia.getHostAddress());
	            	   localAddress = ia;
	               }
	            }   
            }
			
			//Warning : the backlog value (2nd parameter is handled by the implementation
			mySkServer = new ServerSocket(45001,10,localAddress);

			//set 3min timeout
			mySkServer.setSoTimeout(100000);

			System.out.println("Default Timeout :" + mySkServer.getSoTimeout());
			System.out.println("Used IpAddress :" + mySkServer.getInetAddress());
			System.out.println("Listening to Port :" + mySkServer.getLocalPort());

			
			
			//wait for client connection		
			srvSocket = mySkServer.accept(); 	
			
			buffin = new BufferedReader(new InputStreamReader(srvSocket.getInputStream()));
			
			System.out.println("A client is connected :"+ i++);
			
			String message_duclient = buffin.readLine();
	
			System.out.println("je suis le serveur j'ai reçus ce message : " + message_duclient);
//			TimeUnit.SECONDS.sleep(1);
			//Then die
			System.out.println("server close");
			srvSocket.close();
			mySkServer.close();

		}catch (SocketException e) {

			System.out.println("Connection Timed out");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
