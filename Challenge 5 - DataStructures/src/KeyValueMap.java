/**
 * @author pescar2
 */
import java.awt.Color;

public class KeyValueMap // aka Dictionary or Map
{
	private String[] keyA = new String[0];
	private Color[]	valueA = new Color[0];
	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	public void add(String key, Color value)
	{
		if(exists(key))
		{
			for(int i = 0; i < keyA.length; i++)
			{
				if(keyA[i] == key)
					valueA[i] = value;
			}
		}
		else
		{
			String[] oldMap = keyA;
			Color[] oldValue = valueA;
			keyA = new String[oldMap.length +1];
			valueA = new Color[oldValue.length +1];
			
			for(int i = 0;i < oldMap.length;i++)
			{
				keyA[i] = oldMap[i];
				valueA[i] = oldValue[i];
			}
			
			keyA[keyA.length -1] = key;
			valueA[valueA.length -1] = value;
		}
	}//end of add

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key)
	{
		int keyV = -1;
		for(int i = 0; i < keyA.length; i++)
		{
			if(keyA[i].equals(key))
				keyV = i;
		}
		if(keyV >= 0)
			return valueA[keyV];
		
		return null;
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key)
	{
		for(int i = 0; i < keyA.length;i++)
		{
			if(keyA[i].equals(key))
				return true;
		}
		return false;
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key)
	{
		int keyV = -1;
		String[] oldMap = keyA;
		Color[] oldValue = valueA;
		keyA = new String[oldMap.length -1];
		valueA = new Color[oldValue.length -1];
		
		for(int i = 0; i < keyA.length; i++)
		{
			if(oldMap[i].equals(key))
				keyV = i;
			
			if(keyV == -1)
			{
				keyA[i] = oldMap[i];
				valueA[i] = oldValue[i];
			}
			else
			{
				keyA[i] = oldMap[i + 1];
				valueA[i] = oldValue[i + 1];
			}
		}
	}//end of remove
}//end of KeyValueMap class
