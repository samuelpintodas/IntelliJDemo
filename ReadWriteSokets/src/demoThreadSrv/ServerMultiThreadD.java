package demoThreadSrv;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

public class ServerMultiThreadD {

	public static void main(String[] args){

		Socket srvSocket = null ;
		InetAddress localAddress = null;
		ServerSocket mySkServer;
		String interfaceName = "eth1";

		int ClientNo = 1; //pour différencier les client qu'il vy avoir
		
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
			
			//wait for a client connection
			while(true)
			{
     		   Socket clientSocket = mySkServer.accept(); // ne s'arrete jamais , et va accepter tout ce qui passe
     		   
               System.out.println("connection request received");
               
               
               Thread t = new Thread(new AcceptClientD(clientSocket,ClientNo));
               //création d'un thread pour chaque client qui se connecteront et feront l'action voulu
               
               ClientNo++; // pour la numérotation des client
               
     		   //starting the thread
    		   t.start();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}