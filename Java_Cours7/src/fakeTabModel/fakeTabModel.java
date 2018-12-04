package fakeTabModel;

import javax.swing.table.AbstractTableModel;

public class fakeTabModel extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 56;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		System.out.println(rowIndex + " / " + columnIndex);
		return "Fake";
	}
	
	@Override
	public String getColumnName(int col){
		
		return "FAKE";
	}

}
