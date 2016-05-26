package com.tal.IMDB;

import java.util.*;

public class IMDB
{
	// Attributes
	
	private Map<String,Movie> movies = new HashMap<>();
	
	// Constructors
	
	
	// getter and setters
	
	public Map<String,Movie> getMovies()
	{
//		Map<String,Movie> tempMovie = new HashMap<>();
//
//		tempMovie.putAll(this.movies);
//		
//		return tempMovie;
		
		return Collections.unmodifiableMap(this.movies);
	}
	
	
	public void addMovie(String name, Set<String> actors) throws Exception
	{
		try
		{
			if (!movies.containsKey(name))
			{
				movies.put(name, new Movie(name, actors));
			}
			else
			{
				throw new Exception("Movie already exist");
			}
		}
		catch (Exception e)
		{
			throw new Exception(e.getMessage()!="" ? e.getMessage() : "Can't add new movie");
		}
		
	}
	
	public void addActor(String name, String actor) throws Exception
	{
		try
		{
			this.movies.get(name).addActor(actor);
		}
		catch (Exception e)
		{
			throw new Exception("movie not exist1");
		}
	}
	
	public void vote(String name, int voting)
	{
		try
		{
			this.movies.get(name).updateRank(voting);
		}
		
		catch (IllegalArgumentException e)
		{
			throw new NullPointerException();
		}
	}
	
	public List<Movie> getTop(int number) 
	{
		if (number>movies.values().size())
		{
			throw new IllegalArgumentException("There are only " + movies.values().size() + " items");
		}
		
		List<Movie> tmpList = new ArrayList<>(movies.values());

		Collections.sort(tmpList,new Comparator<Movie>() {
			public int compare(Movie m1, Movie m2)
			{
				if (m1.getRank()>m2.getRank()) return -1;
				if (m1.getRank()<m2.getRank()) return 1;
				return 0;
			}
		});
		return tmpList.subList(0, number);
		
	}
	
	public Collection<Movie> getAll()
	{	
		return movies.values();
	}
}
