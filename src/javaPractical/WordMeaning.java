package javaPractical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordMeaning {
	
	private static boolean doesFileExist(String path) {
		File file = new File(path);
		try (FileReader fileReader = new FileReader(file)) {
			System.out.println("File Exists");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File Does Not Exist");
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	
	public static void main(String[] args) {

		String path = "dictionary_files\\word_meaning.txt";
		
		if(doesFileExist(path)) {
			try {
				File file = new File(path);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line = bufferedReader.readLine();
				//Apple - a fruit, a tech firm	
				
				while (line != null) {
					String[] parts = line.split("-");
					String word = parts[0];
					System.out.println(word);
					String[] meanings = parts[1].split(",");
					for(String meaning: meanings) {
						System.out.println(meaning);
					}
					// read next line
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("File Does Not Exist");
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}
