/**@author pescar2
 * 
 */
public class DVD
{
	protected static String[] gen = {"comedy", "drama", "documentary", "horror", "romance", "musical"};
	protected static int len = 30; // for display style
	protected String title;
	protected int genre;
	protected double originalRentalPrice; // original rental price
	protected double salePrice; // sale price
	protected boolean onSale = false;
	protected int numberOfTimesRented; // times of rented
	protected boolean isCurrentlyRented = false; //whether rented or not
	protected DVD next; //for linkedList

	public DVD(String a, double p, DVD d, int g)
	{
		this.title = a;
		this.originalRentalPrice = p;
		this.next = d;
		this.genre = g;
		if(a.length() > DVD.len)
		{
			DVD.len = a.length() + 5;
		}
	}


	public String toString()
	{
		String result = "";
		String a = "";
		String b = "";
		String c = "";
		
		if(!this.isCurrentlyRented)
		{
			for(int i = 0; i < DVD.len - this.title.length(); i++)
			{
				a += " ";
			}

			if(onSale)
			{
				for(int i = 0; i < 6 - Double.toString(this.salePrice).length(); i++)
				{
					b += " ";
				}
			}
			else
			{
				for(int i = 0; i < 6 - Double.toString(this.originalRentalPrice).length(); i++)
				{
					b += " ";
				}
			}

			for(int i = 0; i < 4 - Integer.toString(this.numberOfTimesRented).length(); i++)
			{
				c += " ";
			}

			if(this.onSale)
			{
				result += (this.title + a + this.salePrice + b + numberOfTimesRented);
				if(this.salePrice == 0.00)
				{
					result += (c + "Currently Free!");
				}

			}
			else
			{
				result += (this.title + a + this.originalRentalPrice + b + numberOfTimesRented);

			}			
		}		
		return result;
	}
	
	public DVD search(String tit)
	{
		if(this.next == null)
		{
			if(this.title.equals(tit))
			{
				return this;
			}
			else
			{
				return null;
			}
		}
		else
		{
			if(this.title.equals(tit))
			{
				return this;
			}
			else
			{
				return this.next.search(tit);
			}
		}
	}
	
	public DVD add(String name, double price, int gene)
	{
		if(this.title == "nothing")
		{
			return new DVD(name, price, null, gene);
		}
		
		if(name.compareTo(this.title) < 0)
		{
			return new DVD(name, price, this, gene); //pay attention to the if sequence
		}

		if(this.next == null)
		{
			this.next = new DVD(name, price, null, gene);
			return this;
		}
		else
		{
			this.next = this.next.add(name, price, gene);
			return this;
		}
	}

	
	public DVD remove(String name)
	{
		if(this.next == null){
			if(this.title.equals(name))
			{
				return null;
			}
			else
			{
				return this;
			}
		}
		else
		{
			if(this.title.equals(name))
			{
				return this.next;
			}
			else
			{
				this.next = this.next.remove(name);
				return this;
			}
		}
	}

	public String displayI()
	{
		String result = "";
		if(this.next == null)
		{
			result += this.toString();
		}
		else
		{
			result += this.toString() + "\n" + this.next.displayI();	
		}
		return result;		
	}

	public static void turnSale(DVD name, double price, boolean change)
	{
		if(change)
		{
			name.onSale = true;
			name.salePrice = price;
		}
		else
		{
			name.onSale = false;
		}
	}

	public String displayG(int i)
	{
		String result = "";
		if(this.next == null)
		{
			if(this.genre == i)
			{
				result += this.toString();
			}
			else
			{
				result += "";
			}
		}
		else
		{
			if(this.genre == i)
			{
				result += this.toString() + "\n" + this.next.displayG(i);
			}
			else
			{
				result += this.next.displayG(i);
			}
		}
		return result;
	}

	public void rentDVD()
	{
		this.isCurrentlyRented = true;
		this.numberOfTimesRented ++;
	}

	public double getPrice()
	{
		if(this.onSale)
		{
			return this.salePrice;
		}
		else
		{
			return this.originalRentalPrice;
		}
	}
}