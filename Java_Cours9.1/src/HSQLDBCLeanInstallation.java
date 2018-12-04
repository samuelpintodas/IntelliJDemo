import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HSQLDBCLeanInstallation
{
	private Connection con;
	private Statement stmt;

	public static void main(String[] args) throws Exception
	{
		HSQLDBCLeanInstallation test = new HSQLDBCLeanInstallation();
	}
	
	public HSQLDBCLeanInstallation() throws java.lang.Exception
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
		
		stmt.execute(
				"SELECT * FROM PERSONNE");

	}

}
