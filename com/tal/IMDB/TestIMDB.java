package com.tal.IMDB;

import java.util.*;

public class TestIMDB {

	public static void main(String[] args) 
	{
		
		IMDB db = new IMDB();

		Set<String> actorsNamesGodFather = new HashSet<>();
		Set<String> actorsNamesDark= new HashSet<>();
		
		actorsNamesGodFather.add("Marlon Brando");
		actorsNamesGodFather.add("Al Pachino");
		actorsNamesDark.add("Hith Ledger");
		
		try
		{
			db.addMovie("The Godfather", actorsNamesGodFather);
			db.vote("The Godfather", 10);
			db.vote("The Godfather", 2);
			db.addMovie("The Dark Knight", actorsNamesDark);
			db.vote("The Dark Knight", 10);
			db.vote("The Dark Knight", 10);
			db.vote("The Dark Knight", 9);
			db.addMovie("Poke", actorsNamesDark);
			db.vote("Poke", 1);
			db.vote("Poke", 10);
			db.vote("Poke", 5);
			System.out.println(db.getAll());
			System.out.println("---------------------------++++------------");
			List<Movie> tmpMovieList = new ArrayList<Movie>();
			tmpMovieList = db.getTop(3);
			for (Movie mov : tmpMovieList)
			{
				System.out.println(mov);
			}
			
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		catch (Exception  e)
		{
			System.out.println(e.getMessage());
		}

		

		
//		try
//		{
//			Movie mov = new Movie("Hello",actorsNames);
////			System.out.println(mov.getActors().toString());
//			System.out.println(mov.toString());
//		}
//		
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
	}

}
