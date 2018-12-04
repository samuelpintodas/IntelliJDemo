package RandomAccessFileTableModel_Daniela;

import java.io.* ;
import javax.swing.table.*;

public class TableModelFromRandomAccessFile extends AbstractTableModel {
	private int recordLength=0 ;
	private int columnCount=0 ;
	private int rowCount=0 ;
	private RandomAccessFile rFile ;
	private byte [] buffer ;
	private int current=-1 ;
	private int [] columnSize ;
	private Person person ;
	
	public TableModelFromRandomAccessFile(File file, int [] columnSize) throws IOException
	{
		this.columnSize = columnSize ;
		
		columnCount = columnSize.length ;
		
		rFile= new RandomAccessFile(file, "r") ;
		
		for (int i=0 ; i<columnSize.length ; i++)
			recordLength += columnSize[i] ;
		
		rowCount = (int) rFile.length() / recordLength ;
		
		buffer = new byte[recordLength] ;
	}
	
	public int getColumnCount() {
		return columnCount ;
	}

	public int getRowCount() {
		return rowCount ;
	}

	public Object getValueAt(int row, int col) {
		try 
		{
			if (current != row)
			{
				/* the record is not in the buffer nor in the Person */
				
				rFile.seek(row * recordLength) ;
				
				/* read the record to the buffer */
				
				rFile.read(buffer) ;
				
				/* create a person from the buffer */
				
				person = createPerson(buffer) ;
			}
			
			switch(col)
			{
				case 0:		
					return person.getId() ;
								
				case 1:				
					return person.getFirstname() ;

				case 2:			
					return person.getLastname() ;
				
				default:
					return "Err" ;
			}
		} 
		
		catch (IOException e)
		{
			System.out.println("Error") ;
		}
		
		return "Err" ;
	}
	
	/* create a person from the buffer */
	private Person createPerson(byte [] buffer)
	{
		return new Person(((buffer[0] << 24) + (buffer[1] << 16) + (buffer[2] <<  8) +  buffer[3]),
							new String(buffer).substring(columnSize[0], columnSize[0] + columnSize[1]).trim(), 
							new String(buffer).substring(columnSize[0] + columnSize[1] , columnSize[0] + columnSize[1] + columnSize[2]).trim()) ;
	}
}
