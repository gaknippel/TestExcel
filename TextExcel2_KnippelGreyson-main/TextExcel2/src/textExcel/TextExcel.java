package textExcel;
 
import java.io.FileNotFoundException;
import java.util.Scanner;
 
// Update this file with your own code.
 
public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner con = new Scanner(System.in); 
		String command = con.nextLine();
		String output = "";
		Spreadsheet s = new Spreadsheet();
	   while (!command.equals("quit"))
	   {
		   output = s.processCommand(command);
		   System.out.println(output);
		   command = con.nextLine();

	   }
	}
}