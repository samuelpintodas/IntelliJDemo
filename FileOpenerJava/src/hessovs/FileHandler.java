package hessovs;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	private String file_name;
	
	public FileHandler(String file_name) {
		// TODO Auto-generated constructor stub
		this.file_name = file_name;
	}
	
	public String readFile() throws IOException{
		String content="";
		
		if((new java.io.File(file_name).exists()) == true){
			java.io.BufferedReader objReader;
			objReader = new java.io.BufferedReader(new FileReader(file_name));
			content = objReader.readLine();
			objReader.close();
			
		}
		else{
			content = "No such file " + file_name; 
		}
			
		return content;
	}
	
	public void writeFile(String text) throws IOException{
		java.io.BufferedWriter objWriter;
		objWriter = new java.io.BufferedWriter(new FileWriter(file_name));
		objWriter.write(text);
		objWriter.close();
	}
	
	
}
