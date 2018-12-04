
public class Hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hanoi(3, "A", "B","C");
	}

	private static void hanoi(int n, String depart, String inter, String arrivee) {
		// TODO Auto-generated method stub
		
		
		
		// Clause de finitude
		if(n==1){
			System.out.println(depart + "\t-->\t" + arrivee);
			return;
		}
		
		
		// pas récursif
			hanoi(n-1, depart, arrivee, inter);
			System.out.println(depart + "\t-->\t" + arrivee);
			hanoi(n-1, inter, depart, arrivee);
		
		
	}

}
