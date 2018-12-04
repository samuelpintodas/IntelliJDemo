
public class Hanoi_time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("time " + time(hanoi(5, "A", "B","C")));
	}

	private static int hanoi(int n, String depart, String inter, String arrivee) {
		// TODO Auto-generated method stub
		
		int mooves = (int) (Math.pow(2, n)-1);
		
		// Clause de finitude
		if(n==1){
//			System.out.println(depart + "\t-->\t" + arrivee);
			return 1;
		}
		
		
		// pas récursif
			hanoi(n-1, depart, arrivee, inter);
//			System.out.println(depart + "\t-->\t" + arrivee);
			hanoi(n-1, inter, depart, arrivee);
		
		return mooves;
	}
	
	private static String time(int mooves){
		
		String time = "";
		
		if(mooves >=365){
			time = "Années : " + (mooves/365);
		}
		else if(mooves<30){
			time = "Jours : " + (mooves/30);
		}
		else
			time = "Mois : " + (mooves/12);
		
		
		
		return time;
		
	}

}
