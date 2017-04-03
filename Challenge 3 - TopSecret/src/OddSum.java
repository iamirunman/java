/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author pescar2
 */
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
public class OddSum
{
	 public static void main(String[] args)
	 { 
		 TextIO.putln("Max?");
		 int input = TextIO.getlnInt();
		 int odd;
		 int total = 0;
		 
		 if (input % 2 == 0)
		 {
			 input -= 1;
		 }
		 
		 for (odd = 1; odd <= input; odd += 2)
		 {
			 if (odd < input)
			 {
				 TextIO.put(odd + " + ");
				 total += odd;
			 }
			 else
			 {
				 TextIO.put(odd + " ");
				 total += odd;
			 }
		 }
		 TextIO.putln("= " + total); 

		 TextIO.put(total + " = ");
		 
		 for (odd = input; odd > 0; odd -= 2)
		 {
			 if (odd == input)
			 {
				 TextIO.put(odd);
				 total += odd;
			 }
			 else
			 {
				 TextIO.put(" + " + odd);
				 total += odd;
			 }
		 }
	}//end of main 
} // end of class 
