/**
 * Prints out only lines that contain an email address Each printed line is
 * justified to right by prepending the text with '.' characters The minimum
 * width of the line including padding is 40 characters. See the test case for
 * example input and expected output.
 * 
 * @author pescar2
 * 
 */
class CallAStaticMethod
{
	public static void main(String[] args)
	{
		while(!TextIO.eof())
		{
			String line = TextIO.getln();
			// Use ExampleClassMethods
			// 'isEmailAddress' and 'createPadding' to complete this method
			if(isEmailAddress(line))
			{
				String padding = createPadding('.', (40 - line.length()));
				TextIO.putln(padding + line);
			}
		}
	}//end of main
	
	/*@param int*/
	public static String createPadding(int num)
	{
		return createPadding('_',num);
	}//end of createPadding
	
	/*@param char, int*/
	public static String createPadding(char pad, int num)
	{
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < num; i++)
		{
			result.append(pad);
		}
		return result.toString();
	}//end of createPadding
	
	public static boolean isEmailAddress(String add)
	{
		return add.indexOf("@") > 0;
	}//end of isEmailAddress
	
}//end of CallAStaticMethod class
