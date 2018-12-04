import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class ServerClient2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
				// Server variables
				Socket srvSocket = null;
				InetAddress localAddress = null;
				ServerSocket mySkServer;
				String interfaceName = "eth1";
				String serverAnswer = null;
		
				//Client variables
				Socket clientSocket;
				BufferedReader buffin;
				InetAddress serverAddress = null;
				PrintWriter pout;
		        String serverName = "127.0.0.1";
		        String command="HELLO";   
		        String passwordSentToPort = null;
		        
		        
	
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
					
					
					  clientSocket = new Socket(serverAddress,10999);

					  // 1. Listen on port 15346
				      mySkServer = new ServerSocket(15346,10,localAddress);
				     
				      mySkServer.setSoTimeout(3000000);
				      
				      System.out.println("Waiting for client");
				      
				      srvSocket = mySkServer.accept();
				      System.out.println("A client is connected.");
				      
				      buffin = new BufferedReader(
  		  					new InputStreamReader(
  		  							srvSocket.getInputStream()));
				      
				      
				      // 2. Receive the command from the client
				      if(buffin.readLine().equals(command)){
				    	  
				    	  // 2.1) Ask for the password
				    	  
					           
				        }
				        else{
				        // 2.2) close connection
				        System.out.println("Incorrect command");
				        srvSocket.close();
						mySkServer.close();
				        }
				      
				      pout = new PrintWriter(srvSocket.getOutputStream());

				      // 5. wait for 20 secondes
				      mySkServer.setSoTimeout(200000);
					
	
					

				}catch (SocketException e) {

					System.out.println("Connection Timed out");
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			
	
	// ------------------- client part----------------------------
	
				
				
	//6. Connect on port 10999
	clientSocket = new Socket(serverAddress,10999);
	System.out.println("We got the connexion to  "+ serverAddress);
	System.out.println("Will read data given by server:\n");
	
	 pout = new PrintWriter(clientSocket.getOutputStream());
	
	//7. Display the question received from the server
	
	
	//8. Send to  server the password written by the user in the console
	pout.println(serverAnswer);
	pout.flush();
	
	//9. Display the answer to the server
	
	
	//10. Close the connection on port 10999
	clientSocket.close();
	
	}
}
