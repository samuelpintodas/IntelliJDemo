package Exercice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewRWClient01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket clientSocket;
		BufferedReader buffin;
		InetAddress serverAddress;
		String serverName = "127.0.0.1";
		
		try{
			
			serverAddress = InetAddress.getByName(serverName);
			System.out.println("Get the address of the server " + serverAddress);
			
			// get a connection from the server
			clientSocket = new Socket(serverAddress, 45001);
			System.out.println("We got a connection to " + serverAddress);
			System.out.println("Will read data given by server:\n");
			
			// create a input stream to read data from the server
			buffin = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// Read a line from the input buffer coming from the server
			String message_distant = buffin.readLine();
			System.out.println(message_distant);
			
			// close the connection
			System.out.println("\nMessage read : " + message_distant + "\nNow dying...");
			clientSocket.close();
			
		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (ConnectException e) {
			
			 System.out.println("\n cannot connect to server");;
		}catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
