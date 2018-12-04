package tabPrenomsModels_Corriger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class myFrame extends JFrame{
	
	private JTable table = new JTable();
	private JScrollPane JSPane = new JScrollPane(table);

	
	public myFrame(FileModel model){
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		table.setModel(model);
		add(JSPane);
	
		
		
	}

}
