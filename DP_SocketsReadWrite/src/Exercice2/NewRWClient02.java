package Exercice2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewRWClient02 {

	public static void main(String[] args) throws InterruptedException {

		Socket clientSocket = null;
		InetAddress serverAddress;
        String serverName = "127.0.0.1";
        PrintWriter pout;
	        
			try {
				serverAddress = InetAddress.getByName(serverName);
				System.out.println("Get the address of the server : "+ serverAddress);
			    
				//get a connection to the server
				Socket mySocket = new Socket(serverAddress,45001);
				System.out.println("We got the connexion to  "+ serverAddress);
				System.out.println("Will read data given by server:\n");

				//create an input stream to read data from the server

				
				//envoie son nom et l'ip au server
				pout = new PrintWriter(mySocket.getOutputStream());//ici je doit que mettre le outpout sous cette forme
				
				System.out.println( "voici le message que je vais envoyer :  " + serverName);
				pout.println( serverName); //ici je peut rajouter qqch si je veux
				

		        pout.flush();
		        mySocket.close();
		        pout.close();
		        

			}catch (UnknownHostException e) {
				
				e.printStackTrace();
			}catch (ConnectException e) {
				
				 System.out.println("\n cannot connect to server");;
			}catch (IOException e) {
				
				e.printStackTrace();
			}
	
		}

}
