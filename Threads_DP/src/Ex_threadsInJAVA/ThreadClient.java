package Ex_threadsInJAVA;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadClient implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ThreadClient(ServerSocket socketServer, Socket socket, int nbrClient){
		
	}

	@Override
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
