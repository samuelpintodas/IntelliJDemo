package Ex3_Loan;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;

public class NewRWClient {
			
	public static void main(String[] args) {

		Socket clientSocket;
		BufferedReader buffin;
		InetAddress serverAddress;
		PrintWriter envoieMessage;
        String serverName = "10.91.132.233";
        String message_distant="";    
			try {
				serverAddress = InetAddress.getByName(serverName);
				System.out.println("Get the address of the server : "+ serverAddress);
			    
				//get a connection to the server
				Socket mySocket = new Socket(serverAddress,45000);
				System.out.println("We got the connexion to  "+ serverAddress);
				System.out.println("Will read data given by server:\n");

				//create an input stream to read data from the server
				buffin = new BufferedReader (new InputStreamReader (mySocket.getInputStream()));
				
				
		        do
		        {
		        	//Read a line from the input buffer coming from the server
			        message_distant = buffin.readLine();
			        System.out.println("j'ai recu le message du serveur le voici : " + message_distant);
					
			        envoieMessage = new PrintWriter(mySocket.getOutputStream());
			        
			        
		        	 //envoie du message au server
		        	
				        envoieMessage.println(message_distant);
				        envoieMessage.flush();
				        
		        }while(!message_distant.equals("quit"));

				//close the connection
		        System.out.println("\nMessage read. it is " + message_distant +" Now dying...");
		        mySocket.close();

			}catch (UnknownHostException e) {
				
				e.printStackTrace();
			}catch (ConnectException e) {
				
				 System.out.println("\n cannot connect to server");;
			}catch (IOException e) {
				
				e.printStackTrace();
			}
	
		}

}
