/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author pescar2
 */
public class FindScriptLine
{

	public static void main(String[] args)
	{
		String searchedWord;
		System.out.println("Please enter the word(s) to search for");
		searchedWord = TextIO.getln();
		System.out.println("Searching for "+"'"+searchedWord+"'");
		TextIO.readFile("thematrix.txt");
		
		int count = 0;
		
		while(false == TextIO.eof())
		{
			String line = TextIO.getln();
			
			count++;
			if((line.toLowerCase().contains(searchedWord.toLowerCase())))
				{
				line = line.trim();
				TextIO.putln(count+" - "+line);
				}
			
		}
		TextIO.writeStandardOutput();
		System.out.println("Done Searching for "+"'"+searchedWord+"'");
	}
}
//TODO: Implement the functionality described in FindScriptLine.txt
//TODO: Test your code manually and using the automated unit tests in FindScriptLineTest