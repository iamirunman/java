/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author pescar2
 */
public class MovieSurvey
{
	public static void main(String[] arg)
	{
		//TODO: Write your program here
		int cinema, player, computer;
		System.out.println("Welcome. We're interested in how people are watching movies this year.");
		System.out.println("Thanks for your time. - The WRITERS GUILD OF AMERICA.");
		System.out.println("Please tell us about how you've watched movies in the last month.");
		System.out.println("How many movies have you seen at the cinema?");
		cinema = TextIO.getlnInt();
		System.out.println("How many movies have you seen using a DVD or VHS player?");
		player = TextIO.getlnInt();
		System.out.println("How many movies have you seen using a Computer?");
		computer = TextIO.getlnInt();
		
		System.out.println("Summary: "+cinema+" Cinema movies, "+player+" DVD/VHS movies, "+computer+" Computer movies");
		int total = cinema+player+computer;
		System.out.println("Total: "+total+" movies");
		double percentAt = ((double)cinema/(double)total)*100;
		double percentOut = 100.00-(((double)cinema/(double)total)*100);
		TextIO.putf("Fraction of movies seen at a cinema: %.2f%%\n", percentAt);
		TextIO.putf("Fraction of movies seen outside of a cinema: %.2f%%", percentOut);
	}
}

// Hints :
// Formatted output
// http://math.hws.edu/javanotes/c2/s4.html#basics.4.4
// Don't just copy paste the expected output
// For grading purposes your code may be tested
// with other input values.