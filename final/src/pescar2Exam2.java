
import java.util.Scanner;

public class pescar2Exam2 {

	public static void main (String[] args){
	   System.out.println ("Type in integer values via standard input (zero to quit).");
	   System.out.println ("Any number of integer values can be given per line of input.");
	   
	   //initialize queues
	   linkedQueue positive = new linkedQueue();
	   linkedQueue negative = new linkedQueue();
	   linkedQueue multipleOfFour = new linkedQueue();
	   
	   // create an instance of the scanner class to read from standard input
	   Scanner scan = new Scanner(System.in);
	   int userInput;
	   
	   // read in first value
	   userInput = scan.nextInt();
	   while ( userInput != 0)
	   {
	     if(userInput > 0){
	        positive.enqueue(userInput);	//enqueue to the positive list
	     }
	     if(userInput < 0){
	    	 negative.enqueue(userInput);	//enqueue to the negative list
	     }
	     if(userInput % 4 == 0){
	    	 multipleOfFour.enqueue(userInput);	//enqueue to the multiple of four list
	     }
	     userInput = scan.nextInt();
	   }
	   System.out.println("Finished reading input\n");
	   
	   int data;
		
	   int counter = 0;
	   System.out.println("Positive values in the same order:");
	   while(positive.isEmpty() == false){
			counter++;
			data = positive.front();
			System.out.print(data + " ");
			if(counter % 8 == 0 && counter != 0){
				System.out.println();
			}
			positive.dequeue();
	   }
	   System.out.println();
	   
	   
	   counter = 0;
	   System.out.println();
	   System.out.println("Negative values in the same order:");
	   while(negative.isEmpty() == false){
			counter++;
			data = negative.front();
			System.out.print(data + " ");
			if(counter % 8 == 0 && counter != 0){
				System.out.println();
			}
			negative.dequeue();
	   }
	   System.out.println();
	   
	   
	   counter = 0;
	   System.out.println();
	   System.out.println("The Multiples of 4 in the same order:");
	   while(multipleOfFour.isEmpty() == false){
			counter++;
			data = multipleOfFour.front();
			System.out.print(data + " ");
			if(counter % 8 == 0 && counter != 0){
				System.out.println();
			}
			multipleOfFour.dequeue();
	   }
	   System.out.println("\n");
	   
	   // close the scanner
	   scan.close();
	   
	   System.out.println ("Goodbye");
	}//end of main
	
}//end of class pescar2Exam2
