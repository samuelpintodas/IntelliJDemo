package ListIterator;
import java.util.Comparator;


public class SortPersonByFirstname implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2){
		
//		System.out.println("compare Called");
		
			if(!(p1 instanceof Person) || !(p2 instanceof Person))
				throw new ClassCastException();
			
		
			int r;
			
			if((r = p1.getFirstname().compareTo(p2.getFirstname())) == 0)
				if((r = p1.getLastname().compareTo(p2.getLastname())) == 0)
					if((r = Integer.compare(p1.getAge(), p2.getAge())) == 0)
					return 0;
			
			
		
		return r;
	}

}
