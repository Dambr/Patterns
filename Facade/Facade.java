// Нужен, чтобы спрятать какой то сложный функционал
// за простостой интерфейс

import java.io.*;

public class Facade{
	public static void main(String[] args) {
		try{
			System.out.println(FileFacade.readFile("text.txt"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

class FileFacade{
	static String readFile(String FileName) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(FileName));
		StringBuilder stringBuilder = new StringBuilder();
		int j = 0;
		while ((j = reader.read()) != -1){
			stringBuilder.append((char)j);
		}
		return stringBuilder.toString();
	}
}