package Ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class RWClient_Inverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket clientSocket;
		InetAddress serverAddress;
		String serverName = "127.0.0.1";
		PrintWriter pout;
		
		try {
			serverAddress = InetAddress.getByName(serverName);
			System.out.println("Get the address of the server : "+ serverAddress);

			//Ask the server to create a new socket
			clientSocket = new Socket(serverAddress,45000);
			System.out.println("We got the connexion to  "+ serverAddress);
			System.out.println("now dying....");
			
			//open the iutput data stream to write on the client
			pout = new PrintWriter(clientSocket.getOutputStream());
			
			//wait for an input from the console
			String message = "Voici mon hostname: " + serverName;
			
			pout.println(message);
			pout.flush();
			
			
			//close the connection
			System.out.println("\nMessage read. Now  dying...");
			clientSocket.close();
			pout.close();

		}catch (UnknownHostException e) {

			e.printStackTrace();

		}catch(ConnectException e){
			
			System.out.println("\n cannot connect to server");
			
		}catch (IOException e) {

			e.printStackTrace();
			
		}
	}

}
