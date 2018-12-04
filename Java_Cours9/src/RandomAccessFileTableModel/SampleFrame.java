package RandomAccessFileTableModel;

import javax.swing.*;
import javax.swing.table.*;


public class SampleFrame extends JFrame {
	JTable table = new JTable() ;
	JScrollPane scroll = new JScrollPane(table) ;
	
	public SampleFrame(TableModel model)
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		table.setModel(model);
		
		add(scroll) ;
		
		pack() ;
	}
}
