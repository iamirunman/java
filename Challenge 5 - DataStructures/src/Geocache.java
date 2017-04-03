/**
 * Create a class 'Geocache' with two private instance variables 'x' 'y' of type double and a private integer 'id'
 * .
 * A class variable 'count' will also be required to count the number of times a Geocache object has been created (instantiated).
 * Create two constructors - one which takes two double parameters (the initial values of x,y). The
 * second constructor will take another Geocache and initialize itself based on that geocache.
 * 
 * For both constructors set the Geocache's id to the current value of count (thus the first geocache will have the value zero)
 * when the Geocache is created, then increment the count value. 
 * 
 * Also create 'resetCount()' and getNumGeocachesCreated() which returns an int - the number of geocaches created since 
 * resetCount() method was called.
 * 
 * Create an equals method that takes an object reference and returns true if the given object equals this object.
 * Hint: You'll need 'instanceof' and cast to a (Geocache)
 * 
 * Create a toString() method that returns a string representation of this object in the form '(x,y)' where 'x' and 'y'
 * are the current values of x,y.
 * 
 * Create the four getX/getY/setX/setY methods for x,y.
 * However the setX() method will only change the Geocache's x value if the given value is between -1000 and 1000 exclusive (i.e. -1000<x<1000).
 * If the value is outside of this range, the new value is ignored and the Geocache's x value remains unchanged.
 *   
 * Create a get method for id.
 * 
 * 
 * @author pescar2
 */

class Geocache
{
	private double x;//private instance variables
	private double y;
	private int id;//private integer
	private static int count = 0;//class variable
	
	//first constructor, two param(double)
	public Geocache(double a, double b)
	{
		this.id = count;
		count++;
		x = a;
		y = b;
	}
	//second constructor, one param(Geocache)
	public Geocache(Geocache geoOBJ)
	{
		this.x = geoOBJ.x;//sets x, y, count of current object to those of passed object
		this.y = geoOBJ.y;
		this.id = count;
		count++;
	}
	
	public double getX()//getter method
	{
		return this.x;
	}
	
	public double getY()//getter method
	{
		return this.y;
	}
	
	public int getId()//getter method
	{
		return this.id;
	}
	
	public void setX(double xImput)//setter method *sets x only if -1000 < xImput < 1000
	{
		if((double)-1000 < xImput && xImput < (double)1000)//type-casting makes 1000 1000.00
			this.x = xImput;
	}
	
	public void setY(double yImput)//setter method
	{
		this.y = yImput;
	}
	
	public static void resetCount()//does not return anything
	{
		count = 0;
	}
	
	public static int getNumGeocachesCreated()//returns int
	{
		return count;
	}
	
	public boolean equals(Object other)//returns boolean
	{
		if(other instanceof Geocache)//if other is an instance of the object Geocache
		{
			Geocache geoOBJ = (Geocache)other;//type-cast other and set it to new object geoOBJ
			return (this.x == geoOBJ.x) && (this.y == geoOBJ.y);//return true if objects have the same x, y
		}
		
		return false;
	}
	
	public String toString()//returns a string representation of object that calls it
	{	
		return "(" + this.x + "," + this.y + ")";
	}
}//end of Geocache class
