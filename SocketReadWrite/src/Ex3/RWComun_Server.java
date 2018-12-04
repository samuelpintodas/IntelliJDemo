package Ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;

public class RWComun_Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket mySkServer;
		Socket srvSocket = null;
		InetAddress localAddress = null;
		String interfaceName ="eth1";
		PrintWriter poutServ;
		BufferedReader buffinServ;
		Scanner scan;
		int i = 0;
		
		try {
			NetworkInterface ni = NetworkInterface.getByName(interfaceName);
	        Enumeration<InetAddress> inetAddresses =  ni.getInetAddresses();
	        
	        // Cherche le prochain port ouvert
			while(inetAddresses.hasMoreElements()) {
	            InetAddress ia = inetAddresses.nextElement();
	            
	            if(!ia.isLinkLocalAddress()) {
	               if(!ia.isLoopbackAddress()) {
	            	   System.out.println(ni.getName() + "->IP: " + ia.getHostAddress());
	            	   localAddress = ia;
	               }
	            }   
            }

			mySkServer = new ServerSocket(45000,5,localAddress);

			System.out.println("Default Timeout :" + mySkServer.getSoTimeout());
			System.out.println("Used IpAddress :" + mySkServer.getInetAddress());
			System.out.println("Listening to Port :" + mySkServer.getLocalPort());

			mySkServer.setSoTimeout(180000);//set 3min timeout

            //Listen to a client connection wait until a client connects			
			System.out.println("Waiting for a client connection:");
			srvSocket = mySkServer.accept(); 

			System.out.println("A client is connected: " + i++);

			//open the output data stream to write on the client
			poutServ = new PrintWriter(srvSocket.getOutputStream());
			
			//wait for an input from the console
			scan = new Scanner(System.in);
			System.out.println("Your message:" );
			String message = scan.nextLine();
			
			if(message!= "quit"){
			
			//write the message on the output stream
			poutServ.println(message);
			poutServ.flush();
			
			//create an input stream to read data from the server
			buffinServ = new BufferedReader(
									new InputStreamReader(
									srvSocket.getInputStream()));
			}
			
			else{
			//the die
			System.out.println("Now dying");
			srvSocket.close();
			mySkServer.close();
			poutServ.close();
			

			System.out.println("Closing socket....");
			}

		}catch (SocketException e) {

			//System.out.println("Connection Timed out");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
