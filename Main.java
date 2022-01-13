import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
public class Main 
{
	public static void main(String[] args) 
	  {
		/*Psuedocode -- I want to write a program that reads input from a file, and gives the user multiple
		 * chances to enter the file name. 
		 * -Prompt user to open a file
		 * -Create and instantiate file scanner object
		 * -if exception is not thrown
		 * 		-Parse input from file
		 * 		-Prompt user to open another file or quit
		 * -else if exception is thrown
		 * 		-throw FileNotFoundException
		 * 		-prompt user to enter a file name
		 */
		System.out.println("Welcome to my file opener/reader program!");
		Scanner input = new Scanner(System.in);
		filePrompt(input);
		boolean isFound = false;
		
		while(isFound == false)
		try {
			String fileName = getFileName(input);
			Scanner inFile = createFileReader(fileName);
			readFile(inFile);
			isFound = true;
		}
		catch(FileNotFoundException myException) {
			System.out.println("FileNotFoundException name wasn't found, so the program threw my custom exception!");
		}	
		
		
	  }
	public static String filePrompt(Scanner input)
	{
		System.out.println("Would you like to open a file? y/n");
		String ans = input.next();
		return ans;
	}
	public static String getFileName(Scanner input) 
	{
		input.reset();
		System.out.println("Enter file name: ");
		String fileName = input.next();
		return fileName;
	}
	public static Scanner createFileReader(String fileName)throws FileNotFoundException
	{
		 Scanner inFile = new Scanner(new File(fileName));
		 return inFile;
	}
	public static void readFile(Scanner inFile)
	{
		while(inFile.hasNext())
		{
			String input = inFile.next();
			System.out.printf("%s ", input);
		}
		inFile.close();
	}
	
	
	
}


	
	
