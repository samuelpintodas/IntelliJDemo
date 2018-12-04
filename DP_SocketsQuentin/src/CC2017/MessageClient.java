package CC2017;

//Quentin Remion


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class MessageClient {
	public static void main(String[] args) throws IOException {	
	
		Socket clientSocket;
		InetAddress serverAddress;
		String serverName = "127.0.0.1";
		String message = "";	
		
		try {
			serverAddress = InetAddress.getByName(serverName);
			clientSocket = new Socket(serverAddress, 67766);
			
			Scanner scan = new Scanner(System.in);
			BufferedReader buffin = new BufferedReader(
										new InputStreamReader(
											clientSocket.getInputStream()));
			
			PrintWriter pout = new PrintWriter(clientSocket.getOutputStream());
				
			System.out.println("Enter command (READ or ADD):");
			message = scan.nextLine();
			
			
			
			if(message=="READ") {
				pout.println(message);
				pout.flush();
				message = buffin.readLine();
				System.out.println("The message:    " + message);
				
				System.out.println("Disconnected");
			
				
			}
			if(message=="ADD") {
				pout.println(message);
				pout.flush();
				clientSocket.close();
				System.out.println("Disconnected");
				clientSocket = new Socket(serverAddress, 68877);
				System.out.println("connected");
				pout.println("Quentin: bonjour");
				pout.flush();
				
			}
			else {
				System.out.println("Not a valid command");
			}
				
			buffin.close();
			pout.close();
			clientSocket.close();
			
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
