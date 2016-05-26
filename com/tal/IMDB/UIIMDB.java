package com.tal.IMDB;


import java.util.*;

public class UIIMDB 
{
	private IMDB db = new IMDB();
	private Scanner sc = new Scanner(System.in);
	private String input;
	private boolean stop = false;
	
	public UIIMDB() 
	{
		this.getCommand();
	}
	
	public void getCommand() 
	{	

		try
		{				
			while (!stop)
			{
			input = sc.nextLine();
			List<String> tempStr = new ArrayList<>();
			tempStr = getText();
			
			switch (tempStr.get(0))
			{
				case "add": 
					{
						String actorName = tempStr.get(1);
						tempStr.remove(0);
						tempStr.remove(0);
						db.addMovie(actorName, actorsName(tempStr));
						System.out.println("New movie was created");
						break;
					}
				case "addactor":
					{
						db.addActor(tempStr.get(1), tempStr.get(2));
						System.out.println("Actor: " + tempStr.get(2) + " was added to movie: " + tempStr.get(1));
						break;
					}
				case "vote": 
					{
							db.vote(tempStr.get(1),Integer.parseInt(tempStr.get(2)));
							System.out.println("Vote for" + tempStr.get(0) + " was accepted");
							break;
					}
				case "print":
				{
					System.out.println(db.getAll());
					break;
				}
				case "gettop":
				{
					System.out.println(db.getTop(Integer.parseInt(tempStr.get(1))));
					break;
				}
				case "end": 
				{
					System.out.println("Thank you");
					stop = true;
					break;
				}
				case "?": 
					{
						System.out.println("add: for adding new movie [add;movie name;actor 1;actor2.....;]");
						System.out.println("addactor: for adding new actor to an exist movie [addactor;movie name;new actor name;]");
						System.out.println("vote: for voting to an exist movie [add;movie name;rank;]");
						System.out.println("print: print all movies details [print]");
						System.out.println("gettop: print all movies details for top n movies by rank [gettop;n;]");
						System.out.println("end: close console");
						System.out.println("?: help");
					}
					
			}
			
			}
		}
		catch (NullPointerException e)
		{
			System.out.println("You can vote for movie in the database only");
		}	
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		catch (Exception  e)
		{
			System.out.println("Error " + e.getMessage());
		}
	//	sc.close();
	}
	
	public List<String> getText()
	{	
		List<String> tempStr = new ArrayList<>();
		

			Scanner sc2 = new Scanner(input);
			sc2.useDelimiter(";");
			
			while (sc2.hasNext())
			{			
				tempStr.add(sc2.next());		
			}
			
		sc2.close();	
		return tempStr;

	}
	
	
	public Set<String> actorsName(List<String> names)
	{
		Set<String> tempSet = new HashSet<>();
		tempSet.addAll(names);
		return tempSet;
	}
}
