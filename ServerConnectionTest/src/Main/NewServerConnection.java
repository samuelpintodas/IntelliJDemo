package Main;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class NewServerConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ServerSocket mySkServer ;
		Socket srvSocket = null ;
		InetAddress localAddress=null;
		String interfaceName = "eth1";


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

			mySkServer.setSoTimeout(30000);//set 30 sec timeout

            //Listen to a client connection wait until a client connects			
			System.out.println("Waiting for a client connection:");
			srvSocket = mySkServer.accept(); 

			System.out.println("A client is connected");

			mySkServer.close();
			srvSocket.close();

			System.out.println("Closing socket....");

		}catch (SocketException e) {

			//System.out.println("Connection Timed out");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}