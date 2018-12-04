package FenetreSynchro;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class myFrame extends JFrame{

	JTextField jf = new JTextField();
	
	static int cpt = 1;
	
	
	public myFrame(Document model){
		
		super(cpt+ ". MVC very simple example");
		
		Dimension dim = new Dimension (300, 100);
		FlowLayout l = new FlowLayout();
		jf.setDocument(model);
		jf.setPreferredSize(dim);
		setLayout(l);
		setSize(300, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		cpt++;
		
		add(jf);
	}
}
