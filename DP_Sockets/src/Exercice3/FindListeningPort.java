package Exercice3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FindListeningPort {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		InetAddress serverAddress;
		String serverName = "127.0.0.1";
		
		try{
			
			serverAddress = InetAddress.getByName(serverName);
			
			int port;
			Socket mySocket;
			
			for(port = 44980; port<=45010; port++){
				
				try{
					
					mySocket = new Socket(serverAddress, port);
					
					System.out.println("The server is listening on port n° " + port);
					
					mySocket.close();
					
					break;
					
				} catch (IOException ex) {
					//MyName: The remote host is not listening on this port
					System.out.println("Not found on port " + port);
				}
			}
			
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("server connection error, dying.....");
		}catch(NullPointerException e){
			System.out.println("Connection interrupted with the server");
		}
	}

}
