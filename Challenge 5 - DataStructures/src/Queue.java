/**
 * 
 * @author pescar2
 *
 */
public class Queue
{
	private double[] arr = new double[0];//instance variables
	private int length = arr.length;
	
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	public void add(double value)
	{
		double[] old = arr;
		length++;
		arr = new double[length];
		arr[0] = value;
		
		for(int i = 1; i < length; i++)
		{
			arr[i] = old[i-1];
		}
	}
	
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove()
	{
		if(this.isEmpty())//if queue is empty
		{
			return 0;
		}
		
		double[] old = arr;
		length--;
		arr = new double[length];
		
		for(int i = 0; i < length; i++)
		{
			arr[i] = old[i];
		}
		return old[length];
	}
	
	/** Returns the number of items in the queue. */
	public int length()
	{
		return length;		
	}
	
	/** Returns true if & only if the queue is empty */
	public boolean isEmpty()
	{
		return length == 0;
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString()
	{
		String queueRep = "";
		for(int i = (length - 1); i > 0; i--)
		{
			queueRep += arr[i] + ",";
		}
		
		queueRep += arr[0];
		return queueRep;
	}
}//end of Queue class