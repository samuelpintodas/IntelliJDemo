package Exercice1;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;

public class ServerGetPort {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ServerSocket myskServer;
		Socket srvSocket;
		InetAddress localAddress=null;
		String interfaceName = "eth1";
		
		try{
			
			NetworkInterface ni = NetworkInterface.getByName(interfaceName);
			Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
			
			while(inetAddresses.hasMoreElements()){
				InetAddress ia = inetAddresses.nextElement();
				if(!ia.isLinkLocalAddress())
					if(!ia.isLoopbackAddress()){
						System.out.println(ni.getName() + ":\t" + ia.getHostAddress());
						localAddress = ia;
					}
			}
			
			myskServer = new ServerSocket(45000, 5, localAddress);
			
			System.out.println("Server address:\t" + myskServer.getInetAddress());
			System.out.println("Server default timeout:\t" + myskServer.getSoTimeout());
			System.out.println("Server local port:\t" + myskServer.getLocalPort());
			
			// ------------------------------ part for exercice 2 ---------------------------------------------------
			myskServer.setSoTimeout(30000);
			System.out.println("Waiting for a client connection");
			
			srvSocket = myskServer.accept();
			System.out.println("A client is connected");
			
			myskServer.close();
			srvSocket.close();
			
			System.out.println("Connection closed");
			
		}catch(Exception e){
			throw e;
		}
	}

}
