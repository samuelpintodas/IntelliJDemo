package Acheteur;

import java.util.ArrayList;

public class Acheteur implements Runnable {
	
	private Sac sac;
	private String name;
	
	public Acheteur (Sac s, String name){
		
		this.name = name;
		sac = s;
	}


	@Override
	public void run() {
		
		for(int i=0 ; i<50; i++){
			String test = "'x" + i + "'";
			sac.add("x" + i);
			System.out.println(name +" achète " + test);
		}
	}

		
}
