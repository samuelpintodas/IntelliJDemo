package Acheteur;

import java.util.ArrayList;

public class Sac {
	
	private ArrayList<String> list = new ArrayList<String>();
	
	// Lorsqu'un thread appelle 'add', tant qu'il n'en est pas sorti, aucun autre thread ne peut l'appeler
	public synchronized void add(String item){
		
		list.add(item);
		
	}
	
	public String getSize(){
		
		return "Taille du sac: " + list.size();
	}

}
