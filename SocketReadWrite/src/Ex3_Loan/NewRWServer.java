package Ex3_Loan;

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
import java.io.PrintWriter;
public class NewRWServer {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Socket srvSocket = null ;
		InetAddress localAddress = null;
		ServerSocket mySkServer;
		PrintWriter pout;
		BufferedReader buffinDuClient;
		Scanner sc; 
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
			mySkServer = new ServerSocket(45000,10,localAddress);

			//set 3min timeout
			mySkServer.setSoTimeout(50_000_000);

			System.out.println("Default Timeout :" + mySkServer.getSoTimeout());
			System.out.println("Used IpAddress :" + mySkServer.getInetAddress());
			System.out.println("Listening to Port :" + mySkServer.getLocalPort());

			//wait for client connection		
			srvSocket = mySkServer.accept(); 			
			System.out.println("A client is connected :"+ i++);
			
			//open the output data stream to write on the client
		pout = new PrintWriter(srvSocket.getOutputStream());

			

		//en attente de la reponse du client 
		//create an input stream to read data from the server
		String reponse_Client ="";
       do 
       {
    	 
    	  //attend la réponse du client
    	 //wait for an input from the console 
			sc = new Scanner(System.in);			  
		System.out.println("write the message :");
		String message = sc.nextLine();

		System.out.println("je suis le server voici le message que je vais envoyer " +message);
			//write the message on the output stream
		pout.println(message);
		pout.flush();		
		
		//reception
    	   buffinDuClient = new BufferedReader (new InputStreamReader (srvSocket.getInputStream()));
    	   reponse_Client = buffinDuClient.readLine();
    	   System.out.println("voici ce que le client me dit " + reponse_Client);
       }
       while(!reponse_Client.equals("quit"));
     //die die die
		System.out.println("server close");
		srvSocket.close();
		mySkServer.close();
		pout.close();
      
		
			

		}catch (SocketException e) {

			System.out.println("Connection Timed out");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
