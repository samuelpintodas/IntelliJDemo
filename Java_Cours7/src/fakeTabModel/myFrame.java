package fakeTabModel;

import javax.swing.*;
import javax.swing.table.TableModel;


public class myFrame extends JFrame{
	
	private JTable table = new JTable();
	private JScrollPane JSPane = new JScrollPane(table);

	
	public myFrame(TableModel model){
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		table.setModel(model);
		add(JSPane);
	
		
		
	}

}
