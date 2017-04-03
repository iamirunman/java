//import java.io.*;
import java.util.Scanner;

public class pescar2 {

	public static void main (String[] args){
	   System.out.println ("Type in integer values via standard input (zero to quit).");
	   System.out.println ("  Any number of integer values can be given per line of input.");
	   
	   // create an instance of the scanner class to read from standard input
	   Scanner sc = new Scanner ( System.in );
	   int value;
	   
	   // read in first value
	   value = sc.nextInt();
	   while ( value != 0)
	   {
	     System.out.println ("The value is: " + value);
	     value = sc.nextInt();
	   }
	   System.out.println ("Finished reading input\n");
	   
	   // print out 30-some random integer values in aligned columns with 8 values per line
	   for (int i = 1; i <= 37; i++)
	   {
	     // get some random integer in range from -999 to +999
	     int num = 1000 - (int)(Math.floor(Math.random() * 1999));
	     // print the value in a column 6 characters wide
	     System.out.printf ("%6d ", num);
	     // check if 8 values have been printed on this row/line
	     if (i % 8 == 0)
	       System.out.println();
	   }
	   System.out.println();
	   
	   System.out.println ("Goodbye");
	}//end of main
	
	
}//end of class pescar2
