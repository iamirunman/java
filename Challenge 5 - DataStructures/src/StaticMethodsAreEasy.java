// Oh no... Someone removed  the methods but left the comments!!
// Hint: Get the Geocache class working and passing its tests first.
/**
 * @author pescar2
 */
public class StaticMethodsAreEasy
{
	/**
	 * Returns an array of num geocaches. Each geocache is initialized to a random
	 * (x,y) location.
	 * if num is less than zero, just return an empty array of length 0.
	 * 
	 * @param num
	 *            number of geocaches to create
	 * @return array of newly minted Points
	 */
	//write the method here...
	public static Geocache[] createGeocaches(int num)
	{
		Geocache [] result;
		if (num < 0)
			result = new Geocache[0];
		else
		{
			result = new Geocache[num];
			for(int i = 0; i < num; i++)
			{
				result[i] = new Geocache((double)Math.random()*100, (double)Math.random()*100);
			}
		}
		return result;		
	}
	/**
	 * Modifies geocaches if the geocache's X value is less than the allowable minimum
	 * value.
	 * 
	 * @param p
	 *            array of geocaches
	 * @param minX
	 *            minimum X value.
	 * @return number of modified geocaches (i.e. x values were too small).
	 */
	//write the method here...
	public static int ensureMinimumXValue(Geocache[] geoOBJ, double min)
	{
		int count = 0;
		for(int i = 0;i < geoOBJ.length; i++)
		{
			if(geoOBJ[i].getX()< min)
			{
				geoOBJ[i].setX(min);
				count++;
			}
		}
		return count;
	}
	/**
	 * Counts the number of geocaches that are equal to the given geocache
	 * Hint: Use geocache.equals() method 
	 * @param p -
	 *            geocache array
	 * @param test -
	 *            test geocache (compared using .equal)
	 * @return number of matching geocaches
	 */
	//write the method here...
	public static int countEqual(Geocache[] geoOBJ, Geocache test)
	{
		int count = 0;
		for(int i = 0; i < geoOBJ.length; i++)
		{
			if(geoOBJ[i].equals(test))
			{
				count++;
			}
		}
		return count;
	}
}//end of StaticMethodsAreEasy class
