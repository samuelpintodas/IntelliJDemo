package Ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class RWComun_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket clientSocket;
		InetAddress serverAddress;
		String serverName = "10.91.129.30";
		BufferedReader buffinClient;
		PrintWriter poutClient;
		
		try {
			serverAddress = InetAddress.getByName(serverName);
			System.out.println("Get the address of the server : "+ serverAddress);

			//Ask the server to create a new socket
			clientSocket = new Socket(serverAddress,45000);
			System.out.println("We got the connexion to  "+ serverAddress);
			System.out.println("now dying....");
			
			//create an input stream to read data from the server
			buffinClient = new BufferedReader(
									new InputStreamReader(
									clientSocket.getInputStream()));
			
			//Read a line from the input buffer coming from the server
			String message_distant = buffinClient.readLine();
			if(buffinClient.readLine() != "quit")
			System.out.println("Message reçu: " + message_distant);
			
			//close the connection
			else{
			System.out.println("\nMessage = 'quit'. Now dying...");
			clientSocket.close();
			}

		}catch (UnknownHostException e) {

			e.printStackTrace();

		}catch(ConnectException e){
			
			System.out.println("\n cannot connect to server");
			
		}catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}
	
}
