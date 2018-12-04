package FenetreSynchro;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Document mydoc = new DefaultStyledDocument();

		myFrame mf1 = new myFrame(mydoc);
		myFrame mf2 = new myFrame(mydoc);
		myFrame mf3 = new myFrame(mydoc);
		
		mf1.setVisible(true);
		mf2.setVisible(true);
		mf3.setVisible(true);
		
	}

}