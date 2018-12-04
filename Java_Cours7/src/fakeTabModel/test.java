package fakeTabModel;

import javax.swing.table.TableModel;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TableModel model = new fakeTabModel();

		new myFrame(model).setVisible(true);
		
	}

}
