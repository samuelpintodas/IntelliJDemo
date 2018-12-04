package ThreadsInterface;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Accept_clients {
	
	private ServerSocket socketserver;
	private Socket socket;
	private int nbrclient = 1;
	
	//Constructor
	public Accept_clients(ServerSocket s){
		socketserver = s;
	}
	
	//Overwrite the thread run()
	public void run(){
		
		try{
			
			//infinite loop
			while(true){
				socket = socketserver.accept();
				System.out.println("Client Nr " + nbrclient + " is connected");
				nbrclient ++;
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
