package tabPrenomsModels;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.table.TableModel;

public class test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		String fileName = "D:/Documents/HES/2ème année/semestre 1/Java/testNames.txt";
		String [] columnName = {"number","LastName", "FirstName"};
		
		FileModel model = new FileModel(fileName,";", columnName);
		

		new myFrame(model).setVisible(true);
		
	}

}
