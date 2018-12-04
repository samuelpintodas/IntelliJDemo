import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Scanner;

public class ClientServer1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//Client variables
		Socket clientSocket;
		BufferedReader buffin;
		InetAddress serverAddress;
		PrintWriter pout;
        String serverName = "127.0.0.1";
        String command="HELLO";   
        String passwordSentToPort = null;
        String passwordClient = null;
  
        
		// Server variables
		Socket srvSocket = null;
		InetAddress localAddress = null;
		ServerSocket mySkServer;
		String interfaceName = "eth1";
		String serverAnswer = null;
		//--------------Client Part----------------------------------------------------        
			try {
				
				// get the serverAddress
				serverAddress = InetAddress.getByName(serverName);
				System.out.println("Get the address of the server : "+ serverAddress);
			    
				//1. Connect on port 15346
				clientSocket = new Socket(serverAddress,15346);
				System.out.println("We got the connexion to  "+ serverAddress);
				System.out.println("Will read data given by server:\n");

				//create an input stream to read data from the server
				buffin = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
				
				passwordSentToPort = buffin.readLine();
				
		      
		        	
			    pout = new PrintWriter(clientSocket.getOutputStream());
		        	 
		        // 2. send to the server the command "HELLO"
				pout.println(command);
				
				serverAnswer = buffin.readLine();
				
				// 3. display from the server asking for a password
				System.out.println(serverAnswer);
				pout.flush();       
		       
				// 4. Send to the server the password entered by the user
				// and save the password
				System.out.println("Please write your password");
				passwordClient = input.nextLine();
				
				pout.println(passwordClient);
				pout.flush();
		        
		        // 5. disconnect from port 15346
		        clientSocket.close();
		        
		        
		        // 6. Wait for 10 seconds
		        clientSocket.setSoTimeout(100000);
		  

			}catch (UnknownHostException e) {
				
				e.printStackTrace();
			}catch (ConnectException e) {
				
				 System.out.println("\n cannot connect to server");;
			}catch (IOException e) {
				
				e.printStackTrace();
			}
			
			//--------------Server Part----------------------------------------------------
	
			
			try {
				
				// find the local address
				NetworkInterface ni = NetworkInterface.getByName(interfaceName);
		        Enumeration<InetAddress> inetAddresses =  ni.getInetAddresses();
				while(inetAddresses.hasMoreElements()) {
		            InetAddress ia = inetAddresses.nextElement();
		            
		            if(!ia.isLinkLocalAddress()) 
		            {
		               if(!ia.isLoopbackAddress()) 
		               {
		            	   System.out.println(ni.getName() + "->IP: " + ia.getHostAddress());
		            	   localAddress = ia;
		               }
		            }   
	            }

				  // 7. Listen on por 10999
			      mySkServer = new ServerSocket(10999,10,localAddress);
			     
			      mySkServer.setSoTimeout(3000000);
			      
			      System.out.println("Waiting for client");
			      
			      srvSocket = mySkServer.accept();
			      System.out.println("A client is connected.");
			      
			      pout = new PrintWriter(srvSocket.getOutputStream());
			      
			      buffin = new BufferedReader(
			    		  					new InputStreamReader(
			    		  							srvSocket.getInputStream()));
			      
			      // Received password from client
			      // 8. Ask for password to the client
			      passwordClient = buffin.readLine();
			      
			      // compare the password received from the client 
			      // to the password sent to port 15346 
			      if(passwordClient.equals(passwordSentToPort)) 
			    	  pout.println("Welcome back");
			      else
			    	  pout.println("You are not welcomed");
				

			// 11. Close the connection on port 10999
			srvSocket.close();
			mySkServer.close();
				

			}catch (SocketException e) {

				System.out.println("Connection Timed out");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

}
