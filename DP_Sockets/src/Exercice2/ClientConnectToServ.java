package Exercice2;

import java.net.InetAddress;
import java.net.Socket;

public class ClientConnectToServ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Socket clientSocket;
		InetAddress serverAddress;
		String serverName = "127.0.0.1";
		
		try{
			
			serverAddress = InetAddress.getByName(serverName);
			System.out.println("Get the address of the server: " + serverAddress);
			
			clientSocket = new Socket(serverAddress,45000);
			
			System.out.println("We got the connexion to " + serverAddress);
			System.out.println("Now dying");
			
			clientSocket.close();
			
		}catch(Exception e){
			throw e;
		}
		
	}

}
