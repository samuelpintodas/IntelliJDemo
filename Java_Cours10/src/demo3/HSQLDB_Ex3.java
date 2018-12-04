package demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class HSQLDB_Ex3
{
	private Connection con;
	private Statement stmt;

	public static void main(String[] args) throws Exception
	{
		HSQLDB_Ex3 test = new HSQLDB_Ex3();
	}
	
	public HSQLDB_Ex3() throws java.lang.Exception
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
		
		PreparedStatement prepared_update = con.prepareStatement(
				"UPDATE PERSONNE SET PERS_PRENOM = ? WHERE PERS_ID = ?");
		
		prepared_update.setString(1, "L'hirondelle");
		prepared_update.setInt(2, -1);
		
		prepared_update.execute();
		
		
		prepared_update.execute(
				"SELECT * FROM PERSONNE");
		
		ResultSet r = prepared_update.getResultSet();
		
		while(r.next())
		{
		System.out.println(r.getInt("PERS_ID"));
		System.out.println(r.getString("PERS_PRENOM"));
		System.out.println(r.getString("PERS_NOM"));
		}
		System.out.println("");
	
		prepared_update.setString(1, "Savioz");
		prepared_update.setInt(2, -3);
		
		prepared_update.execute();
		
		
	}
	
	
	
}
