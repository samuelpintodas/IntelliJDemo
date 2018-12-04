package Exercice1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;

public class NewRWServer01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket srvSocket = null;
		InetAddress localAddress = null;
		ServerSocket mySkServer;
		String interfaceName = "eth1";
		
		PrintWriter pout;
		Scanner input;
		int i=0;
		
		try{
			NetworkInterface ni = NetworkInterface.getByName(interfaceName);
			Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
			while(inetAddresses.hasMoreElements()){
				InetAddress ia = inetAddresses.nextElement();
				if(!ia.isLinkLocalAddress())
					if(!ia.isLoopbackAddress()){
						System.out.println(ni.getName() + " IP : " + ia.getHostAddress());
						localAddress = ia;
					}
			}
			
			mySkServer = new ServerSocket(45001, 10, localAddress);
			
			mySkServer.setSoTimeout(180000);
			
			System.out.println("Default Timeout :" + mySkServer.getSoTimeout());
			System.out.println("Used IpAddress :" + mySkServer.getInetAddress());
			System.out.println("Listening to Port :" + mySkServer.getLocalPort());
			
			// wait for a client connection
			srvSocket = mySkServer.accept();
			System.out.println("A client is connected");
			
			//Permet de communiquer via un ouput datastream
			pout = new PrintWriter(srvSocket.getOutputStream());
			
			// wait for an input form the console
			input = new Scanner(System.in);
			System.out.println("Write the message :");
			String message = input.nextLine();
			
			// write the message on the output stream
			pout.println(message);
			pout.flush();
			
			// Then die
			System.out.println("Server close");
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
