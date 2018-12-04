package customDemo;
import java.util.logging.*;
import java.io.*;

public class Logging_test_custom_demo {
	/**
	 * @param args
	 * arg[0] level of logging
	 */
	// Define the level of log
	// 1 = info
	// 2 = severe    
	public static void main(String[] args){

		//Get the logger
		Logger myLogger = Logger.getLogger("TestLog");

		//Define a file handler
		FileHandler fh;

		//Define the logger level without parameters
		if (args.length == 0){
			myLogger.setLevel(Level.INFO);
		}
		else{

			//Define the logger level with parameters
			int valIn = Integer.parseInt(args[0]);

			//check valid values
			if ((valIn > 2) || (valIn < 1))
			{
				myLogger.setLevel(Level.INFO);
			}
			//We are in range  
			switch(valIn){
			case 1 :
				myLogger.setLevel(Level.INFO);
				break;
			case 2 :
				myLogger.setLevel(Level.SEVERE);
				break;
			}
		}
		try{
			// define a new file handler and its log
			//fh = new FileHandler(".\\my.log",true);
			fh = new FileHandler("./my.log",true);

			//add the handle to the log            
			myLogger.addHandler(fh);

			//use a simple formatter 
			SimpleFormatter formatter = new SimpleFormatter();
			Logging_test_custom_demo cForm = new Logging_test_custom_demo();
			fh.setFormatter(formatter);

			//do some logs
			myLogger.info("this is the info level");
			myLogger.log(Level.INFO,"this is the info level v2");            
			//
			myLogger.severe("this is the severe level");
			myLogger.log(Level.SEVERE,"this is the severe level v2");            

		} catch (RuntimeException ex) {
			myLogger.log(Level.SEVERE,"exception thrown",ex);
			ex.printStackTrace();
		} catch (IOException ex) {
			myLogger.log(Level.SEVERE,"exception thrown",ex);
			ex.printStackTrace();
		}

		// end program
		myLogger.setLevel(Level.INFO);
		myLogger.info("=========== program ends =============");
	}
}
