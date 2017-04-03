/**
 * 
 * @author pescar2
 *
 */
public class Stack
{
	private String[] stack = new String[0];
	
	/** Adds a value to the top of the stack.*/
	public void push(String value)
	{
		String[] source = stack;
		stack = new String[source.length + 1];
		stack[0] = value;
		
		for(int i = 1; i < stack.length; i++)
		{
			stack[i] = source[i-1];
		}
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop()
	{
		if(isEmpty())
			return null;
		
		String[] old = stack;
		stack = new String[old.length - 1];
		
		for(int i = 0; i < old.length -1; i++)
		{
			stack[i] = old[i + 1];
		}
		return old[0];
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek()
	{
		if(isEmpty())
			return null;
		return stack[0];
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty()
	{
		return stack.length == 0;
	}

	/** Returns the number of items in the stack. */
	public int length()
	{
		return stack.length;
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString()
	{
		String stackRep = "";
		if(stack.length > 0)
		{
			for(int i = (stack.length - 1); i >= 0; i--)
			{
				stackRep += stack[i] + "\n";
			}
		}
		return stackRep;
	}
}//end of Stack class