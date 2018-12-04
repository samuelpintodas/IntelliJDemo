import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person [] people = new Person [5];
		
		people[0] = new Person("amanda", "zuber", 15); 
		people[1] = new Person("alain", "zhen", 54);
		people[2] = new Person("andre", "ziegler", 43);
		people[3] = new Person("zoe", "bart", 26);
		people[4] = new Person("zachari", "bono", 8);
		
		
		System.out.println("\nunsorted");
		System.out.println("-------------");
		
		for(int i=0; i<people.length; i++)
			System.out.println(people[i].toString());
	
		Arrays.sort(people, new SortPersonByFirstname());
	
		System.out.println("\nsorted");
		System.out.println("-------------");
		
		for(int i = 0; i<people.length; i++)
			System.out.println(people[i].toString());
		
		
	}

}
