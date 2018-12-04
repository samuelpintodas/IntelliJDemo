package RandomAccessFileTableModel;

import java.io.*;
import javax.swing.table.*;

public class TableModelFromRandomAccessFile extends AbstractTableModel
{
	private int recordLength = 0;
	private int columnCount = 0;
	private int rowCount = 0;
	private RandomAccessFile rFile;
	private byte[] buffer;
	private int current = -1;
	private int[] columnSize;
	private Person person;

	public TableModelFromRandomAccessFile(File file, int[] columnSize) throws IOException
	{
		this.columnSize = columnSize;

		columnCount = columnSize.length;

		rFile = new RandomAccessFile(file, "r");

		for (int i = 0; i < columnSize.length; i++)
			recordLength += columnSize[i];

		rowCount = (int) rFile.length() / recordLength;

		// buffer = new byte[recordLength] ;
	}

	public int getColumnCount()
	{
		return columnCount;
	}

	public int getRowCount()
	{
		return rowCount;
	}

	public Object getValueAt(int row, int col)
	{
		try
		{
			if (current != row)
			{
				/* the record is not in the buffer nor in the Person */

				rFile.seek(row * recordLength);

				int id = rFile.readInt();
				byte[] b = new byte[15];
				rFile.read(b);
				String firstname = new String(b);
				rFile.read(b);
				String lastname = new String(b);
				person = new Person(id, firstname, lastname);

				current = row;
			}

			switch (col)
			{
			case 0:
				return person.getId();

			case 1:
				return person.getFirstname();

			case 2:
				return person.getLastname();

			default:
				return "Err";
			}
		}

		catch (IOException e)
		{
			System.out.println("Error");
		}

		return "Err";
	}

}
