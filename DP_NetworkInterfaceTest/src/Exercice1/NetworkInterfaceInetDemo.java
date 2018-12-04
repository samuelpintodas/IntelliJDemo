package Exercice1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Scanner;

public class NetworkInterfaceInetDemo {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {   	
		try {

			//list of all interfaces
			Enumeration<NetworkInterface> allni;

			System.out.println("----->External Linked up interfaces and their addresses (no loopback)");
			
			//get all the interfaces of your machine
			allni = NetworkInterface.getNetworkInterfaces();
			while(allni.hasMoreElements()) {
				NetworkInterface nix = allni.nextElement();
				
				//get the interfaces names if connected
				if (nix.isUp()){
					//System.out.println("interface name: " + nix.getName());
					
					//get the addresses of each interface
					Enumeration<InetAddress> LocalAddress =  nix.getInetAddresses();
					while(LocalAddress.hasMoreElements()) {
			            InetAddress ia = LocalAddress.nextElement();
			            
			            if(!ia.isLinkLocalAddress()) {
			               if(!ia.isLoopbackAddress()) {
			            	   System.out.println(nix.getName() + "->IP: " + ia.getHostAddress());
			               }
			            }   
		            }
				}
				
			}
			
			// get the IP adress of http://www.hes-so.ch
			
			InetAddress hesso = InetAddress.getByName("hes-so.ch");
			System.out.println("hes-so.ch->IP: " + hesso.getHostAddress());
			
			// get the IP adress of a given internet adress
			Scanner input = new Scanner(System.in);
			String address;
			InetAddress myAddress;
			
			System.out.println("Write an web adress:");
			address = input.nextLine();
			myAddress = InetAddress.getByName(address);
			
			System.out.println("Written address->IP: " + myAddress.getHostAddress());
			
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}