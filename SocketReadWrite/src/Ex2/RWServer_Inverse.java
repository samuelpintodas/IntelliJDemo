package Ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class RWServer_Inverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket mySkServer;
		Socket srvSocket = null;
		InetAddress localAddress = null;
		String interfaceName = "eth1";
		BufferedReader buffin;
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

			//create an input stream to read data from the client
			buffin = new BufferedReader(
										new InputStreamReader(
												srvSocket.getInputStream()));
			
			// Read a line from the input buffer coming from the server
			String distantMessage_hostname = buffin.readLine();
			System.out.println(distantMessage_hostname);
			
		
			
			//Close the connection
			System.out.println("Closing socket....");
			srvSocket.close();
			mySkServer.close();
			

			

		}catch (SocketException e) {

			//System.out.println("Connection Timed out");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		
	}

}
