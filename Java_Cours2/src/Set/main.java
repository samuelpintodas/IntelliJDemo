package Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import ListIterator.Person;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set s = new HashSet();
		
		Person hanni = new Person ("Hannibal", "Lecter", 42);
		
		s.add(new Person("amanda", "zuber", 15)); 
		s.add(new Person("alain", "zhen", 54));
		s.add(new Person("andre", "ziegler", 43));
		s.add(new Person("zoe", "bart", 26));
		s.add(new Person("zachari", "bono", 8));
		s.add(hanni);
		s.add(hanni);
	
		
	
		System.out.println("current size : " + s.size() + " not ");
		
		print(s);
	}
	
	public static void print (Collection c){
		
		Iterator i  = c.iterator();
		
		while(i.hasNext()) {
			Person p = (Person) i.next();
			System.out.println(p.toString());
		}
	}

}
