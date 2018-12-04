package FenetreSynchro_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;

public class myFrame extends JFrame{

	JTextField jf = new JTextField();
	JTextPane jp = new JTextPane();
	JTextArea ja = new JTextArea();
	Dimension dim = new Dimension (300, 100);
	static int cpt = 1;
	
	
	public myFrame(Document model, int textZone){
		
		super(cpt+ ". MVC very simple example");
		
		FlowLayout l = new FlowLayout();
		
		switch(textZone)
		{
		case 1:
			jf.setDocument(model);
			jf.setPreferredSize(dim);
			jf.setBackground(Color.RED);
			add(jf);
			break;
		
		case 2:
			jp.setDocument(model);
			jp.setPreferredSize(dim);
			jp.setBackground(Color.GREEN);
			add(jp);
			break;
		
		case 3:
			ja.setDocument(model);
			ja.setPreferredSize(dim);
			ja.setBackground(Color.YELLOW);
			add(ja);
			break;
			
		default:
			System.out.println("textZone error");
			JLabel error = new JLabel("     TEXTZONE ERROR");
			error.setPreferredSize(dim);
			add(error);
			break;
		}

		setLayout(l);
		setSize(300, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		cpt++;
		
		
	}
}
