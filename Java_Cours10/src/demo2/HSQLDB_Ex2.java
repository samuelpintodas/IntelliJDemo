package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HSQLDB_Ex2
{
	private Connection con;
	private Statement stmt;

	public static void main(String[] args) throws Exception
	{
		HSQLDB_Ex2 test = new HSQLDB_Ex2();
	}
	
	public HSQLDB_Ex2() throws java.lang.Exception
	{
		Class.forName("org.hsqldb.jdbcDriver");
		
		String url = "jdbc:hsqldb:/c:/temp/hsqldb_file";
		
		con = DriverManager.getConnection(url, "sa", "");
		
		System.out.println("HSQLDB tested successfuly, seems to be installed successfuly.");
		
		/* create database */
		stmt = con.createStatement(	ResultSet.TYPE_FORWARD_ONLY, 
									ResultSet.CONCUR_READ_ONLY);
		
		// SQL Query changed in comparison with SQLite
		stmt.execute(
				"CREATE TABLE PERSONNE (PERS_ID INTEGER NOT NULL, "+
				"PERS_PRENOM VARCHAR(25) NOT NULL, " +
				"PERS_NOM VARCHAR(25) NOT NULL, " +
				"PRIMARY KEY (PERS_ID))");
		
		stmt.execute(
				"INSERT INTO PERSONNE(PERS_ID, PERS_PRENOM, PERS_NOM)"+
				"VALUES(1, 'Bob', 'Pakay')");
		
		stmt.execute(
				"INSERT INTO PERSONNE(PERS_ID, PERS_PRENOM, PERS_NOM)"+
				"VALUES(2, 'Terrence', 'Babouinos')");
		
		stmt.execute(
				"INSERT INTO PERSONNE(PERS_ID, PERS_PRENOM, PERS_NOM)"+
				"VALUES(3, 'Jack', 'Napier')");
		
		executeSomeQueries();
	}

	public void executeSomeQueries() throws java.lang.Exception
	{
		//printTablePerson("after CREATE");
		
		/* UPDATE */
		
		Statement stmt_updatable = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
														ResultSet.CONCUR_UPDATABLE);
		
		stmt_updatable.execute("SELECT PERS_ID, PERS_PRENOM, PERS_NOM FROM PERSONNE");
		
		ResultSet r = stmt_updatable.getResultSet();
		
		while(r.next())
		{
			r.updateString("PERS_PRENOM", "L'Hirondelle");
			
			r.updateRow();
		}
		
		stmt_updatable.close();
		
		stmt.execute(
				"SELECT * FROM PERSONNE");
		
		r = stmt.getResultSet();
		
		
		while(r.next())
		{
		System.out.println(r.getInt("PERS_ID"));
		System.out.println(r.getString("PERS_PRENOM"));
		System.out.println(r.getString("PERS_NOM"));
		}
		System.out.println("");
	
		/* DELETE */
		
		Statement stmt_deletable = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
														ResultSet.CONCUR_UPDATABLE);
		
		stmt_deletable.execute("SELECT PERS_ID, PERS_PRENOM, PERS_NOM FROM PERSONNE");
		
		r = stmt_deletable.getResultSet();
		
		while(r.next())
			if(r.getInt("PERS_ID")== -2)
				r.deleteRow();
		
		stmt_updatable.close();
		
		r = stmt.getResultSet();
		
		
		while(r.next())
		{
		System.out.println(r.getInt("PERS_ID"));
		System.out.println(r.getString("PERS_PRENOM"));
		System.out.println(r.getString("PERS_NOM"));
		}
		System.out.println("");
		
		/* INSERT */
		
		Statement stmt_insertable = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
														ResultSet.CONCUR_UPDATABLE);
		
		stmt_insertable.execute("SELECT PERS_ID, PERS_PRENOM, PERS_NOM FROM PERSONNE");
		
		r = stmt_insertable.getResultSet();
		
		r.moveToInsertRow();
		
		r.updateInt("PERS_ID", 4);
		r.updateString("PERS_NOM", "P�t�");
		r.updateString("PERS_PRENOM", "John");
		
		r.insertRow();
		
		stmt_updatable.close();
		
		while(r.next())
		{
		System.out.println(r.getInt("PERS_ID"));
		System.out.println(r.getString("PERS_PRENOM"));
		System.out.println(r.getString("PERS_NOM"));
		}
		System.out.println("");
	}
	
	
	
}
