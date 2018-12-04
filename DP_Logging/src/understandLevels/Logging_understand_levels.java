package understandLevels;
import java.util.Date;
import java.util.logging.*;
import java.io.*;

public class Logging_understand_levels {
	/**
	 * @param args
	 */
	//extend the current Formatter
	public static class SocketFormatter extends Formatter {

		public SocketFormatter() {
			super();
		}

		public String format(LogRecord record) {

			// Create a StringBuffer to contain the formatted record
			StringBuffer sb = new StringBuffer();

			// Get the date from the LogRecord and add it to the buffer
			Date date = new Date(record.getMillis());
			sb.append(date.toString());
			sb.append(";");

			sb.append(record.getSourceClassName());
			sb.append(";");

			// Get the level name and add it to the buffer
			sb.append(record.getLevel().getName());
			sb.append(";");

			sb.append(formatMessage(record));
			sb.append("\r\n");

			return sb.toString();
		}
	}

	// Define the level of log
	// 1 = info
	// 2 = severe    
	public static void main(String[] args){

		//Get the logger
		Logger myLogger = Logger.getLogger("TestLog");

		try{
			// define a new file handler and its log
			FileHandler fh = new FileHandler("./my.log",true);

			//add the handle to the log            
			myLogger.addHandler(fh);

			//use a custom formatter 
			SocketFormatter myFormatter = new SocketFormatter();
			fh.setFormatter(myFormatter);

			myLogger.setLevel(Level.INFO);
			myLogger.info("\n===========this is the INFO level============");
			myLogger.info("I write an INFO information");
			myLogger.warning("I write a WARNING information");
			myLogger.severe("I write a SEVERE information");

			myLogger.setLevel(Level.WARNING);
			myLogger.warning("===========this is the WARNING level============");
			myLogger.info("I write an INFO information");
			myLogger.warning("I write a WARNING information");
			myLogger.severe("I write a SEVERE information");
			
			myLogger.setLevel(Level.SEVERE);
			myLogger.severe("===========this is the SEVERE level============");
			myLogger.info("I write an INFO information");
			myLogger.warning("I write a WARNING information");
			myLogger.severe("I write a SEVERE information");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
