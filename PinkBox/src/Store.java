/**@author pescar2
 * 
 */
public class Store
{
	protected static DVD list = new DVD("nothing", 0, null, 0);
	
	public static void displayInterface()
	{
		System.out.println("Welcome to the DVD Store!  Select an option below:" + "\n");
		System.out.println("1) add a DVD\n" + "2) remove a DVD\n" + "3) display inventory\n" + "4) on sale / off sale\n" + 
			"5) display genre\n" + "6) rent DVD\n" + "7) quit\n" + "\n" +"Select an option above:");
	}

	public static void choice(int num)
	{
		if(num == 1)
		{
			Store.addDVD();
		}
		else if(num == 2)
		{
			Store.remove();
		}
		else if(num == 3)
		{
			Store.displayInventory();
		}
		else if(num == 4)
		{
			Store.changeSale();
		}
		else if(num == 5)
		{
			Store.displayGenre();
		}
		else if(num == 6)
		{
			Store.rentItem();
		}
		else
		{
			System.out.println("Enter a number from 1 to 7");
			return;
		}
	}

	public static void addDVD()
	{
		System.out.println("Enter title:");
		String name = TextIO.getln();
		
		while (list.search(name) != null)
		{
			System.out.println("..");
			System.out.println("This DVD already exists.");
			System.out.println("Enter a new title:");
			name = TextIO.getln(); 	 	
		}
		 	
		System.out.println("Enter price:");
		Double price = TextIO.getlnDouble();

		String gen = "";
		int genre = -1;
			 
		while(genre == -1)
		{
			System.out.println("Enter DVD genre" + "\n choose from comedy, drama, documentary, horror, romance, musical.");
			gen = TextIO.getln();
			gen = gen.toLowerCase();

			for(int i = 0; i < 6; i++)
			{
				if(gen.equals(DVD.gen[i]))
				{
				 	genre = i;
				}
			}
		}
		Store.list = list.add(name, price, genre);
		System.out.println("DVD added");		
	}

	public static void remove()
	{
		if (Store.list.title.equals("nothing"))
		{
			System.out.println("Nothing to remove.");	
			return;
		}
		
		System.out.println("Enter title:");
		String name = TextIO.getln();
		name = name.toLowerCase();

		while (list.search(name) == null)
		{
			System.out.println("Enter title:");
			name = TextIO.getln();
			name = name.toLowerCase();
		}
		
		list = list.remove(name);
		System.out.println("DVD removed");
		if (list == null)
		{
			list =  new DVD("nothing", 0, null, 0);	
		}
	}
		
	public static void changeSale()
	{
		if (Store.list.title.equals("nothing"))
		{
			System.out.println("Nothing to change.");	
			return;
		}

		DVD item = null;
		String name;
		double price;
		while(item == null)
		{
			System.out.println("Enter a title to toggle on/off sale");
			name = TextIO.getln();
			name = name.toLowerCase();
			item = list.search(name);
		}
		
		if(!item.onSale)
		{
			System.out.println("Not on sale");
			System.out.println("Enter a sale price:");
			price = TextIO.getlnDouble();
			DVD.turnSale(item, price, true);
			System.out.println("DVD now on sale");
		}
		else
		{
			System.out.println("On sale!");
			DVD.turnSale(item, 123, false);
			System.out.println("DVD now not on sale");	
		}		
	}

	public static void displayInventory()
	{
		String a = "";

		for(int i = 0; i < DVD.len - "title".length(); i++)
		{
				a += " ";
		}

		if (Store.list.title.equals("nothing"))
		{
			System.out.println("Nothing to display.");			
		}
		else
		{
			System.out.println("title" + a + "price" + " " + "rent#\n" + Store.list.displayI());
		}
	}

	public static void displayGenre()
	{
		if (Store.list.title.equals("nothing")) 
		{
			System.out.println("No genre yet.");	
			return;		
		}

		String a = "";

		for(int i = 0; i < DVD.len - "title".length(); i++)
		{
			a += " ";
		}

		String gen = "";
		int genre = -1;
			 
		while(genre == -1)
		{
			System.out.println("Please enter genre" + "\n choose from comedy, drama, documentary, horror, romance, musical.");
			gen = TextIO.getln();
			gen = gen.toLowerCase();

			for(int i = 0; i < 6; i++)
			{
				if(gen.equals(DVD.gen[i]))
				{
				 	genre = i;
				}
			}
		}
		
		String display = list.displayG(genre);
		if(display.length() != 0)
		{
			System.out.println("title" + a + "price" + " " + "rent#\n" +display);
		}
		else
		{
			System.out.println("nothing of this genre");
		}
	}

	public static void rentItem()
	{
		if (Store.list.title.equals("nothing"))
		{
			System.out.println("No DVDs available.");	
			return;
		}

		DVD item = null;
		String name;
		double price;
		while(item == null)
		{
			System.out.println("Enter a title to rent:");
			name = TextIO.getln();
			name = name.toLowerCase();
			item = list.search(name);
		}
		price = item.getPrice();
		String answer;
		answer ="abc";

		while(!answer.equals("no")&&!answer.equals("yes"))
		{
			System.out.println("Are you sure you would like us to deduct $" + price + " from your credit card?");
			answer = TextIO.getln();
			answer = answer.toLowerCase();
		}
		
		if(answer.equals("yes") || answer.equals("y"))
		{
			item.rentDVD();
			System.out.println("DVD rented");
		}
		else if(answer.equals("no") || answer.equals("n"))
		{
			return;
		}
	}
	
	public static void main(String[] args)
	{
		while(true)
		{
			Store.displayInterface();
			int choice;
			choice = TextIO.getlnInt();
			if(choice == 7)
			{
				System.out.println("Are you sure you want to quit? - all your data will be lost.");
				String quit = TextIO.getln();
				quit = quit.toLowerCase();
				if(quit.equals("yes") || quit.equals("y"))
				{
					break;
				}			
			}
			else
			{
				Store.choice(choice);
			}
			
			String back = "";
			
			do
			{
				System.out.println("Enter R to return to the menu");
				back = TextIO.getln();
			}
			while(! back.toLowerCase().equals("r"));
		}
	}
}
