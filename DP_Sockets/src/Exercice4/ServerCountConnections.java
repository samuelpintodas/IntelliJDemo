package Exercice4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class ServerCountConnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket myskServer = null;
		Socket srvSocket = null;
		InetAddress localAddress=null;
		String interfaceName = "eth1";
		int i = 0;
		
		try{
			
			NetworkInterface ni = NetworkInterface.getByName(interfaceName);
			Enumeration<InetAddress> LocalAddresses = ni.getInetAddresses();
			
			while(LocalAddresses.hasMoreElements()){
				InetAddress ia = LocalAddresses.nextElement();
				if(!ia.isLinkLocalAddress())
					localAddress = ia;
				
			}
		myskServer = new ServerSocket(45000,1,localAddress);
		
		System.out.println("Default Timeout :" + myskServer.getSoTimeout());
		System.out.println("Used IpAddress :" + myskServer.getInetAddress());
		System.out.println("Listening to Port :" + myskServer.getLocalPort());
		
		myskServer.setSoTimeout(180000);
		System.out.println("Default timeout: " + myskServer.getSoTimeout());
		
		while(true){
			srvSocket = myskServer.accept();
			System.out.println("A client is connected. n° " + i++);
			srvSocket.close();
		}
			
		}catch (SocketException e) {			
			System.out.println("Connection Timed out");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
