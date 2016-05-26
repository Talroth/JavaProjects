package com.tal.IMDB;

import java.util.*;

public class Movie 
{
	// Attributes
	
	private String name;
	private Set<String> actors = new HashSet<>();
	private double rank = 0;
	private int numOfVoters = 0;
	
	// Constructors
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String name, Set<String> actors) throws Exception
	{
		this.name = name;
		this.setActors(actors);
	}

	
	// getters and setters
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getActors() 
	{
		return Collections.unmodifiableSet(this.actors);
//		Set<String> tempActors = new HashSet<>();
//		for (String act : actors)
//		{
//			tempActors.add(act);
//		}
//		
//		return tempActors;
	}

	public void setActors(Set<String> actors) throws Exception 
	{
		
//		for (String act : actors)
//		{
//			this.addActor(act);
//		}
		
		this.actors = actors;
	}

	public double getRank() {
		return this.rank;
	}

	public int getNumOfVoters() {
		return numOfVoters;
	}
	
	public void addActor(String name) throws Exception 
	{
		try
		{
			if (!this.actors.contains(name))
			{
				this.actors.add(name);
			}
		}
		
		catch (Exception e)
		{
			throw new Exception("Actor " + name + " already exist in this movie");
		}

	}
	
	public void updateRank(int rank)
	{
		if (rank>=0 && rank<=10)
		{
			this.numOfVoters++;
			this.rank = (this.rank + rank) / numOfVoters;
		}
		else
		{
			throw new IllegalArgumentException("Rank must to be between 0 and 10");
		}
	}
	
	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return "Movie name: " + this.name + " | Rank: " + this.getRank() + " | Number of voters: " + this.numOfVoters + " | Actors: " + this.actors.toString() + "\n";
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		// TODO Auto-generated method stub
		if (!(obj instanceof Movie))
		{
			throw new IllegalArgumentException();
		}
		Movie mov = (Movie)obj;
		if ((mov.name==this.name) && (mov.rank==this.rank))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
}
