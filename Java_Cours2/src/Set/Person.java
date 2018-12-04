package Set;

public class Person implements Comparable<Person>{
	
	private String firstname;
	private String lastname;
	private int age;
	
	public Person (String firstname, String lastname, int age){
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	@Override
	public int compareTo(Person p) {
		
//		System.out.println("compareTo called");
		
		if(this.lastname.compareTo(p.lastname) == 0)
			return Integer.compare(this.age, p.age);
		
		return this.lastname.compareTo(p.lastname);
	}


	public String toString(){
		
		return firstname + "\t\t" + lastname + "\t\t" + age;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getAge() {
		return age;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
