package tabPrenomsModels;

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
	

	private String fileName;
	private String delimiter;
	private String columnName[];
	private BufferedReader bf;
	private int columnCount = 0;
	private int rowCount = 0;
	private int current = 0;
	private String currentLine;
	
	
	public FileModel (String fileName, String delimiter, String columnName[]) throws FileNotFoundException, IOException{
		
		bf = new BufferedReader(new FileReader(fileName));
		
		currentLine = bf.readLine();
		
		rowCount = 1;
		
		columnCount = currentLine.split(delimiter).length;
		
		while(bf.readLine() != null)
			rowCount++;
		
	}
	
	
	
	@Override
	public int getColumnCount() {		
		//return datas[0].length;
		return columnCount;
	}

	@Override
	public int getRowCount() {	
//		return datas.length;
		return rowCount;
	}

	
	@Override
	public String getColumnName(int col){
	
		if(col>=columnName.length)
			return "";
		
		return columnName[col];
		
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		System.out.println(row + " / " + col);
		try {
			
			// Si on est sur la ligne courante, on sort.
			if(current == row)
				return currentLine.split(delimiter)[col];
			
			int forward;
			
			forward = row - current;
			
			
			while(forward > 1)
			{
				bf.readLine();
				forward--;
			}
			
			if(forward < 0)
			{
				reopen();
			
				current =-1;
				
				forward = row-current;
			}
			
			currentLine = bf.readLine();
			
			current = row;
			

		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] tab = currentLine.split(delimiter);
		
		return tab[col];
	}
	
	public void reopen () throws IOException{
		bf.close();
		bf = new BufferedReader(new FileReader(fileName));
		current =-1;
		
	}
}
