package ThreadsSocketsDemo_Widmer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ClientForThread {
	public static void main(String[] args) {

		InetAddress serverAddress;
        String serverName = "192.168.108.10";

		try {
			serverAddress = InetAddress.getByName(serverName);
			System.out.println("Get the address of the server : "+ serverAddress);

			//try to connect to the server
			Socket mySocket = new Socket(serverAddress,45007);

			System.out.println("We got the connexion to  "+ serverAddress);
			
			//wait a bit before exit
			Thread.sleep(30000);
						
			System.out.println("\nTerminate client program...");
			mySocket.close();


		}catch (UnknownHostException e) {

			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("server connection error, dying.....");
		}catch(NullPointerException e){
			System.out.println("Connection interrupted with the server");
		}
	    catch (InterruptedException e) {
			System.out.println("interrupted exception");		
	    }
	}

}
