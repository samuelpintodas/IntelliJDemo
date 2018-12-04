import java.util.HashMap;
import java.util.Map;

public class SimpleHashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map m = new HashMap();
		
		m.put("Lundi",  "Montag");
		m.put("Mardi", "Dienstag");
		m.put("Mercredi", "Mittwoch");
		m.put(null, "?");
		m.put("?", null);
		
		System.out.println("Lundi\t\t=\t" + m.get("Lundi"));
		System.out.println("Mardi\t\t=\t" + m.get("Mardi"));
		System.out.println("Mercredi\t=\t" + m.get("Mercredi"));
		System.out.println("null\t\t=\t" + m.get(null));
		System.out.println("?\t\t=\t" + m.get("?"));
		
	}

}
