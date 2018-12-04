package ListIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List  list = new ArrayList();
		
		list.add(new Person("amanda", "zuber", 15)); 
		list.add(new Person("alain", "zhen", 54));
		list.add(new Person("andre", "ziegler", 43));
		list.add(new Person("zoe", "bart", 26));
		list.add(new Person("zachari", "bono", 8));
		
		
		Collections.sort(list);
		
		System.out.println("current size : " + list.size());
		
		print(list);
		
		
		ListIterator<Person> li = list.listIterator();
		
		if(li.hasNext()){
			Person y = (Person) li.next();
			System.out.println(y);
		}
		
		if(li.hasNext()){
			Person y = (Person) li.next();
			System.out.println(y);
		}
		
		if(li.hasPrevious()){
			Person y = (Person) li.next();
			System.out.println(y);
		}
		
	}
	public static void print (Collection c){
		
		Iterator i  = c.iterator();
		
		while(i.hasNext()) {
			Person p = (Person) i.next();
			System.out.println(p.toString());
		}
	}
	


}
