package Exercice2;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class DisplayInterfaces {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		try{
		// List where we'll put all the interfaces
		Enumeration<NetworkInterface> allNI;
		
		System.out.println("All network interfaces:");
		
		allNI = NetworkInterface.getNetworkInterfaces();
		while(allNI.hasMoreElements()){
			NetworkInterface nix = allNI.nextElement();
			
			System.out.println("interface name: " + nix.getName());
		}
		
		System.out.println("\nUP network interfaces:");
		
		allNI = NetworkInterface.getNetworkInterfaces();
		while(allNI.hasMoreElements()){
			NetworkInterface nix = allNI.nextElement();
			
			if(nix.isUp()){
				System.out.println("interface name: " + nix.getName());
			}
		}
		
		
		}catch(Exception e){
			throw e;
		}
	}

}
