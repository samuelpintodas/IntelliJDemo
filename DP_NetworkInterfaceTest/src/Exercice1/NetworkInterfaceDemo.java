package Exercice1;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {   	
		try {

			//list of all interfaces
			Enumeration<NetworkInterface> allni;
			
			System.out.println("----->All interfaces");
			
			//get all the interfaces of your machine
			allni = NetworkInterface.getNetworkInterfaces();
			while(allni.hasMoreElements()) {
				NetworkInterface nix = allni.nextElement();
				
				//get the interfaces names
				System.out.println("interface name: " + nix.getName());
			}
			
			System.out.println("----->Up interfaces");
			
			//get all the interfaces of your machine
			allni = NetworkInterface.getNetworkInterfaces();
			while(allni.hasMoreElements()) {
				NetworkInterface nix = allni.nextElement();
				
				//get the interfaces names if connected
				if (nix.isUp()){
					System.out.println("interface name: " + nix.getName());
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}