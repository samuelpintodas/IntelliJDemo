package RandomAccessFileTableModel;

import java.io.* ;

import javax.swing.JFrame;
import javax.swing.table.*;


public class RandomAccessFileTest {
	public static void writeFile(File file, Person[] people, int [] columnSize) throws IOException
	{
		RandomAccessFile r = new RandomAccessFile(file, "rw") ;
		
		int recordLength = columnSize[0]+columnSize[1]+columnSize[2] ;
		
		for (int i=0 ; i<people.length ; i++)
		{
			System.out.println("current pos: " + i*recordLength);
			r.seek(i*recordLength);
			
			r.writeInt(people[i].getId());
			
			r.writeBytes(people[i].getFirstname());
			r.write(new byte[columnSize[1] - people[i].getFirstname().length()]); /* bourrage: on
				crée un tableau de byte[] qu'avec des 0 de la taille restante pour compléter la colonne */

			r.seek(i*recordLength+columnSize[0]+columnSize[1]);
			r.writeBytes(people[i].getLastname());
			r.write(new byte[columnSize[2] - people[i].getLastname().length()]);  /* bourrage: on
				crée un tableau de byte[] qu'avec des 0 de la taille restante pour compléter la colonne */
		}
		
		r.close();
	}
	
	public static void readFile(File file, int [] columnSize) throws IOException
	{
		RandomAccessFile r = new RandomAccessFile(file, "r") ;
		
		int recordLength = columnSize[0]+columnSize[1]+columnSize[2] ;
		
		int n = (int) r.length() / recordLength ;
		
		System.out.println("nombre d'enregistrements: " + n) ;
		
		byte [] buffer = new byte[columnSize[1]];					
		
		for (int i=0 ; i<n; i++)
		{
			System.out.println("---------------------------") ;
			
			System.out.println(r.readInt()) ;			// read and display
			
			r.read(buffer) ;							// read the field to the buffer
			System.out.println(new String(buffer)) ;	// create a string from the buffer 
														// and display
			r.read(buffer) ;
			System.out.println(new String(buffer)) ;
		}
		
		r.close();
	}

	public static void main(String[] args) throws IOException {
		
		/* ---- Prepare the file ---- */
		
		Person[] people = new Person[] {
				new Person(1, "Jean", "Dubuis"),
				new Person(2, "Pierre", "Rouiller"),
				new Person(3, "Alphonse", "Paratte"),
				new Person(4, "Jean-Daniel", "Soulier"),
				new Person(5, "Barbara", "Luyet"),
				new Person(6, "Pierre", "Rouiller"),
				new Person(7, "Alphonse", "Paratte"),
				new Person(8, "Jean-Daniel", "Soulier"),
				new Person(9, "Barbara", "Luyet"),
				new Person(10, "Nicole", "Savoy") 
				} ;
		
		int [] columnSize = new int [] {4, 15, 15} ;	// fields lengths in bytes 
		
		writeFile(new File("test.bin"), people, columnSize) ;
		
		/* ---- File prepared  ---- */

		TableModel model = new TableModelFromRandomAccessFile(new File("test.bin"), columnSize) ;

		JFrame sample = new SampleFrame(model) ;
		
		sample.setVisible(true);
	}
}
