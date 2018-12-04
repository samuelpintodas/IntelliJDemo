package tabPrenomsModels_Corriger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.table.AbstractTableModel;

public class FileModel extends AbstractTableModel{
	


	private String [][] datas = {	{"1", "Penny", "Salamin"},
									{"2", "Terence", "Babouinos"},
									{"3", "Alejandro", "Jodorovsky"},
									{"4", "Selina", "Kyle"},
									{"5", "Jack", "Napier"}};
	
	private File names = new File("D:/Documents/HES/2ème année/semestre 1/Java/testNames");
	
	
	
	private Object myFile(int row, int column) throws IOException{
		
	
		String line;
		
    	InputStream flux = new FileInputStream(names.getAbsolutePath());
    	InputStreamReader isr = new InputStreamReader(flux);	
    	BufferedReader br = new BufferedReader(isr);
		        
		    		
		        for(int i = 0; i<row; i++){
		           line = br.readLine();
		        }
		        
		        line = br.readLine().toString();
		        
//		        br.close();

		    String[] parts = line.split(";");
		    return parts[column];
			
	}
	
	
	
	@Override
	public int getColumnCount() {		
		//return datas[0].length;
		return 3;
	}

	@Override
	public int getRowCount() {	
//		return datas.length;
		return 5;
	}

	
	@Override
	public String getColumnName(int col){
		
		switch (col){
		
		case 0:
			return "ID";
		case 1:
			return "Firstname";
		case 2:
			return "Lastname";
		default:
			return "column";
		}
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		System.out.println(rowIndex + " / " + columnIndex);
		try {
			return myFile(rowIndex, columnIndex);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnIndex;
	}
}
