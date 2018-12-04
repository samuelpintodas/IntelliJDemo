package Exercice2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;

public class IPadresses {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		try{
		Enumeration<NetworkInterface> allNI;
		
		System.out.println("External linked up interfaces and their address");
		
		allNI = NetworkInterface.getNetworkInterfaces();
		while(allNI.hasMoreElements()){
			NetworkInterface nix = allNI.nextElement();
			
			if(nix.isUp()){
				
				Enumeration<InetAddress> LocalAddress = nix.getInetAddresses();
				
				while(LocalAddress.hasMoreElements()){
					InetAddress ia = LocalAddress.nextElement();
					
					if(!ia.isLinkLocalAddress())
						if(!ia.isLoopbackAddress())
							System.out.println(nix.getName() + ":\t\t" + ia.getHostAddress());
				}
				
			}
		}
		
		String hesURL = "hes-so.ch";
		
		InetAddress hesAdress = InetAddress.getByName(hesURL);
		System.out.println(hesURL + ":\t" + hesAdress.getHostAddress());
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please write an URL");
		String myURL;
		myURL = input.nextLine();
		InetAddress myAddress = InetAddress.getByName(myURL);
		System.out.println(myURL + ":\t" + myAddress.getHostAddress());
		
		
		}catch(Exception e){
			throw e;
		}
	}

}
