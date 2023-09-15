package com.example.nimaptest;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catid;
	private String title;

	public Category() 
	{
		
	}
	
	public Category(int catid, String title)
	{
		super();
		this.catid = catid;
		this.title = title;
	}

	public int getCatid()
	{
		return catid;
	}

	public void setCatid(int catid) 
	{
		this.catid = catid;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	
	
	
}
