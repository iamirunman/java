/**
 * Complete the following GeocacheList, to ensure all unit tests pass.
 * There are several errors in the code below
 *
 * Hint: Get the Geocache class working and passing its tests first.
 * 
 *@author pescar2 
 *
 */
public class GeocacheList
{
	private Geocache[] data = new Geocache[0];
	private int size = data.length;

	public Geocache getGeocache(int i)
	{
		return data[i];
	}

	public int getSize()
	{
		return size;
	}

	public GeocacheList()//default constructor
	{
		
	}

	public GeocacheList(GeocacheList other, boolean deepCopy)//constructor
	{
		size = other.getSize();
		data = new Geocache[size];
		for(int i = 0; i < size; i++)
		{
			if(deepCopy)
				data[i] = new Geocache(other.getGeocache(i));
			else
				data[i] = other.getGeocache(i);
		}
	}

	public void add(Geocache p)
	{
		size++;
		if(size > data.length)
		{
			Geocache[] old = data;
			data = new Geocache[size + 1];
			for (int i = 0; i < old.length; i++)
				data[i] = old[i];
		}
		data[size-1] = p;
	}

	public Geocache[] removeFromTop()
	{
		size = size - 1;
		Geocache[] result = new Geocache[size];
		if(size != 0)
		{
			for(int i = 0;i < data.length - 1; i++)
			{
				result[i] = data[i+1];
			}
		}
		return result;
	}

	public String toString()
	{
		StringBuffer s = new StringBuffer("GeocacheList:");
		for(int i = 0; i < size; i++)
		{
			if(i > 0)
			{
				s.append(',');
			}
			s.append(data[i]);
		}
		return s.toString();
	}
}// end of GeocacheList class
