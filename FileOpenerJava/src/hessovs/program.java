package hessovs;

import java.io.IOException;

public class program {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if(args[0].contains("read")){
			String file_name = "C://Temp//" + args[1];
			FileHandler fHandler = new FileHandler(file_name);
			String content = fHandler.readFile();
			System.out.println(content);
		}
		if(args[0].contains("write")){
			String file_name = "C://Temp//" + args[1];
			FileHandler fHandler = new FileHandler(file_name);
			fHandler.writeFile(args[2]);
			System.out.println("file written");
		}	
	}

}
