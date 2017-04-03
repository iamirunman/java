/**
 * @author pescar2
 *
 */
public class Person
{
	private final String name;
	private final int age;
	private final char gender;
	private final Person child1; //left child
	private final Person child2; //right child

	public Person(String name, int age, char gender, Person c1, Person c2)
	{
	    this.name=name;
	    this.age=age;
	    this.gender=gender;
	    this.child1 = c1;
	    this.child2 = c2;
	}
	
	public String toString()
	{
	    return name+"*"+age+"*"+gender;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public char getGender() 
	{
		return gender;
	}
	
	public boolean equals(Person p)
	{
		return (this.name.equals(p.name)) &&
				(this.age==p.age) &&
				(this.gender==p.gender);
	}
	
	
	public void print() 
	{
	   System.out.println(this);
	   if(child1 != null)
	       child1.print();
	   if(child2 != null)
	       child2.print();   
	}
	
	public int count() // total person count including this object
	{
		int total = 1;
		if(this.child1 != null)
			total += this.child1.count();
		if(this.child2 != null)
			total += this.child2.count();
		return total;
		//throw new IllegalArgumentException("Not Yet Implemented");
	}
	public int countGrandChildren() // but not greatGrandChildren
	{
		int total = 0;
		if(this.child1 != null)
		{
			if(this.child1.child1 != null)
				total++;
			if(this.child1.child2 != null)
				total++;
		}
		
		if(this.child2 != null)
		{
			if(this.child2.child1 != null)
				total++;
			if(this.child2.child2 != null)
				total++;
		}
		return total;
		//YOUR CODE HERE
		//throw new IllegalArgumentException("Not Yet Implemented");
	}
	
	public int countMaxGenerations()//edit
	{
		int line1 = 0;
		int line2 = 0;
		if(this.child1 != null)
		{
			line1 = this.child1.countMaxGenerations();
		}
		if(this.child2 != null)
		{
			line2 = this.child2.countMaxGenerations();
		}
		return Math.max(line1, line2) + 1;
		//YOUR CODE HERE
		//throw new IllegalArgumentException("Not Yet Implemented");   
	}
	
	public int countGender(char gen)//edit
	{
		int total = (this.gender == gen) ? 1:0;
		if(this.child1 != null)
			total += this.child1.countGender(gen);
		if(this.child2 != null)
			total += this.child2.countGender(gen);
		return total;
		//YOUR CODE HERE
		//throw new IllegalArgumentException("Not Yet Implemented");
	}
	
	
	public Person search(String name, int maxGeneration)
	{
		if(this.name.equals(name))
			return this;
		if(maxGeneration == 0 || (this.child1 == null && this.child2 == null))
			return null;
		if(this.child1.search(name, maxGeneration -1) != null)
			return this.child1.search(name, maxGeneration -1);
		if(this.child2.search(name, maxGeneration -1) != null)
			return this.child2.search(name, maxGeneration -1);
		
		return null;
		//YOUR CODE HERE
		//throw new IllegalArgumentException("Not Yet Implemented");
	}

} // end of class
