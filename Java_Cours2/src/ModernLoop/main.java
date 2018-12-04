package ModernLoop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
		
		Person p = (Person) list.get(4); // acces direct
		
		System.out.println(p.toString());
		
		list.remove(p);
		
		System.out.println("current size : " + list.size());
		
		
	}

}
