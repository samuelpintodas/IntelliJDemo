package CC2017;

//Quentin Remion


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;


public class MessageServer {
	public static void main(String[] args) throws IOException {
		
		ArrayList<ArrayList<String>> liste=new ArrayList<ArrayList<String>>();
		ArrayList<String> ListMessage = new ArrayList<String> ();
		
		ServerSocket mySkSocket;
	    Socket srvSocket;
	    String interfaceName = "eth6";
	    String message = "";
		
		try {
	      mySkSocket = new ServerSocket(67766, 1);
	      mySkSocket.setSoTimeout(3000000);
	      
	      System.out.println("Waiting for client");
	      
	      srvSocket = mySkSocket.accept();
	      System.out.println("A client is connected.");
	      
	      PrintWriter pout = new PrintWriter(srvSocket.getOutputStream());
	      BufferedReader buffin = new BufferedReader(
	    		  					new InputStreamReader(
	    		  							srvSocket.getInputStream()));
	      
	      
	      if(buffin.readLine()=="READ") {
	    	  for(int i = 0 ; i < liste.get(0).size();i++) {
	    		  message=liste.get(0).get(i);
	    		  message=message+"     "+liste.get(0).get(i);
	    	  	  
	    	  }
	    	  pout.println(message);
	    	  pout.flush();
	    	  message = buffin.readLine();
	    	  System.out.println("The message:    " + message);	  
	    	  
	    	  
	      }
	      if(buffin.readLine()=="ADD") {
	    	  mySkSocket.close();
	    	  System.out.println("Disconnected");
	    	  mySkSocket = new ServerSocket(68877, 1);
		      mySkSocket.setSoTimeout(3000000);
		      System.out.println("Waiting for client");
		      srvSocket = mySkSocket.accept();
		      System.out.println("A client is connected.");
		      
		      message = buffin.readLine();
	    	  System.out.println("The message:    " + message);
	    	  ListMessage.add(message);
	      }
	      
	      
	      
	      pout.close();
	      buffin.close();
	      srvSocket.close();
	      mySkSocket.close();
	      System.out.println("Disconnected.");
			
			
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
