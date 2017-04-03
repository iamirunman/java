/**
 * @author pescar2
 *
 */
public class LinkedList
{
	// Get and Set methods are NOT necessary!

	private LinkedList next; 	
	private final String word;

	/** Constructs this link.
	 * @param word ; a single word (never null).
	 * @param next ; the next item in the chain (null, if there are no more items).
	 */
	public LinkedList(String word, LinkedList next)//constructor
	{
		this.word = word;
		this.next = next;
	}

	/**
	 * Converts the entire linked list into a string representation.
	 */
	public String toString()//don't edit
	{
		if (next == null)
			return word;// BASE CASE; no more recursion required
		// Recursive case:
		String restOfString = next.toString(); // Forward Recursion
		return word + ";" + restOfString;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int getCount()//don't edit
	{
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.getCount(); // Forward recursion
	}
	
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param word
	 */
	public void append(String word)//edit
	{
		if(next == null)
			next = new LinkedList(word, null);
		else
			next.append(word);
		//throw new IllegalArgumentException("Not Yet Implemented");
	}
	/**
	 * Recursively counts the total number of letters used.
	 * 
	 * @return total number of letters in the words of the linked list
	 */
	public int getLetterCount()//edit
	{
		int total = word.length();
		if(next == null)
			return total;
		else return total + next.getLetterCount();
		//throw new IllegalArgumentException("Not Yet Implemented");
		// returns the total number of letters. word1.length() +
		// word2.length()+...
		// "A" -> "CAT" -> null returns 1 + 3 = 4.
	}

	/**
	 * Recursively searches for and the returns the longest word.
	 * @return the longest word i.e. word.length() is maximal.
	 */
	public String getLongestWord()//edit
	{
		if(next == null)
			return word;
		else
		{
			String longestWord = next.getLongestWord();
			return (word.length() > longestWord.length()) ? word : longestWord;
		}
		// recursive searches for the longest word
		//throw new IllegalArgumentException("Not Yet Implemented");
	}

	/** Converts linked list into a sentence (a single string representation).
	* Each word pair is separated by a space.
	* A period (".") is appended after the last word.
	* The last link represents the last word in the sentence.*/
	public String getSentence()//edit
	{
		if(next == null)
			return word + ".";
		else return word + " " + next.getSentence();
		//throw new IllegalArgumentException("Not Yet Implemented");
	}
	
	/**
	 * Converts linked list into a sentence (a single string representation).
	 * Each word pair is separated by a space. A period (".") is appended after
	 * the last word. The last link represents the first word in the sentence
	 * (and vice versa). The partialResult is the partial string constructed
	 * from earlier links. This partialResult is initially an empty string. 
	 */
	public String getReversedSentence(String partialResult)//edit
	{
		if(partialResult == "" && next != null)
			return next.getReversedSentence(word + ".");
		if(partialResult == "")
			return word + ".";
		if(next == null)
			return word + " " + partialResult;
		return next.getReversedSentence(word + " " + partialResult);
		//throw new IllegalArgumentException("Not Yet Implemented");
	}
	

	/** Creates a linked list of words from an array of strings.
	 * Each string in the array is a word. */
	public static LinkedList createLinkedList(String[] words)//edit
	{
		return createLinkedList(words, 0);
		//throw new IllegalArgumentException("Not Yet Implemented");
		// Hint: This is a wrapper method. You'll need to create your
		// own recursive method.
		// Yes this is possible _without_ loops!
	}
	
	public static LinkedList createLinkedList(String[] words, int index)//I created
	{
		if(index == words.length-1)
			return new LinkedList(words[index], null);
		else
			return new LinkedList(words[index], createLinkedList(words, index + 1));
	}

	/**
	 * Searches for the following word in the linked list. Hint: use .equals not ==
	 * to compare strings.
	 * 
	 * @param word
	 * @return true if the linked list contains the word (case sensitive)
	 */
	public boolean contains(String word)//edit
	{
		if(word.equals(this.word))
			return true;
		if(next == null)
			return false;
		return next.contains(word);
		//throw new IllegalArgumentException("Not Yet Implemented");
	}

	/** Recursively searches for the given word in the linked list.
	 * If this link matches the given word then return this link.
	 * Otherwise search the next link.
	 * If no matching links are found return null.
	 * @param word the word to search for.
	 * @return The link that contains the search word.
	 */
	public LinkedList find(String word)//edit
	{
		if(this.word.equals(word))
			return this;
		if(next == null)
			return null;
		return next.find(word);
		//throw new IllegalArgumentException("Not Yet Implemented");
	}

	/**
	 * Returns the last most link that has the given word, or returns null if
	 * the word cannot be found.
	 * Hint: Would forward recursion be useful?
	 * @param word the word to search for.
	 * @return the last LinkedList object that represents the given word, or null if it is not found.
	 */
	public LinkedList findLast(String word)//edit
	{
		if(next == null && this.word.equals(word))
			return this;
		if(next == null)
			return null;
		if(this.word.equals(word))
			if(next.contains(word))
				return next.findLast(word);
			else
				return this;
		return next.findLast(word);
		//throw new IllegalArgumentException("Not Yet Implemented");
	}

	public LinkedList insert(String string)//edit
	{
		if(string.compareTo(this.word) < 0)
			return new LinkedList(string, this);
		else if(this.next == null)
			this.next = new LinkedList(string, null);
		else
			this.next = this.next.insert(string);
		return this;
		
		//throw new IllegalArgumentException("Not Yet Implemented");
	}

}
