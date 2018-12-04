package ThreadsSocketsDemo_Widmer;

import java.io.IOException;
import java.net.*;

public class AcceptClient implements Runnable {

	private ServerSocket socketServer;
	private Socket socket;
	private int nbrClient = 1;

	//Constructor
	public AcceptClient(ServerSocket s){
		socketServer = s;
	}

	//overwrite the thread run()
	public void run() {

		try {
			//infinite loop
			while(true){
				socket = socketServer.accept(); // A client wants to connect, we accept him
				System.out.println("Client Nr "+nbrClient+ " is connected");
				
				socket.close();
				nbrClient++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}