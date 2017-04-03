/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author pescar2
 */
public class CaesarCipher
{
	public static void main(String[] strings)
	{
		TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
		int shift = TextIO.getlnInt();
		if(shift == 999 || shift == -999)
			TextIO.putln("Using position shift");
		else
		{
			while((shift == 0) || (shift > 25) || (shift < -25))//out of bounds or none
			{
				TextIO.putln(shift + " is not a valid shift value.");
				TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
				shift = TextIO.getlnInt();
			}
			TextIO.putln("Using shift value of " + shift);
		}//end of else
		
		TextIO.putln("Please enter the source text (empty line to quit)");
		String input = TextIO.getln();
		String text = input.toUpperCase();
		if(shift != 999 && shift != -999)//not shift value continue
		{
			while(!text.equals(""))
			{
				TextIO.putln("Source   :" + input);
				TextIO.put("Processed:");
				for(int i = 0; i < text.length(); i++)
				{
					char c = text.charAt(i);
					
					if(c >= 'A' && c <= 'Z')
					{
						int letter = c - 'A';
						int encrypted = (letter + shift) % 26;
						if(encrypted < 0)
							encrypted += 26;
						c = (char)(encrypted + 'A');
					}
					TextIO.put(c);
				}
				TextIO.putln();
				TextIO.putln("Please enter the source text (empty line to quit)");
				input = TextIO.getln();
				text = input.toUpperCase();
			}//end of while
		}//if
		else
		{
			while(!text.equals(""))
			{
				TextIO.putln("Source   :" + input);
				TextIO.put("Processed:");
				int index = 0;
				for(int i = 0; i < text.length(); i++)
				{
					char l = text.charAt(i);
					if(l >= 'A' && l <= 'Z')
					{
						int letter = l - 'A';
						int encrypted;
						if(shift == 999)//shift case
							encrypted = (letter + index) % 26;
						else
							encrypted = (letter - index) % 26;
						if(encrypted < 0)
							encrypted += 26;
						l = (char)(encrypted + 'A');
					}
					TextIO.put(l);
					index++;
				}
				TextIO.putln();
				TextIO.putln("Please enter the source text (empty line to quit)");
				input = TextIO.getln();
				text = input.toUpperCase();
			}//end of while
		}//end of else
		TextIO.putln("Bye.");
	}//end of main
}//end of class