package com.cognizant.spring.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cognizant.spring.web.validation.ValidEmail;

public class Offer {

	private int id;
	@Size(min=5, max=100, message="Size must be between 5 and 100 characters")
	private String name;
	
	@NotNull
	//@Pattern(regexp=".*\\@.*\\..*",message="E-mail format is incorrect")
	@ValidEmail(min=6,message="This email address is not Valid")
	private String email;
	
	@Size(min=5, max=100, message="Size must be between 10 and 500 characters")
	private String text;
	
	public Offer()
	{
	
	}

	public Offer(String name, String email, String text) {		
		this.name = name;
		this.email = email;
		this.text = text;
	}
	
	

	public Offer(int id, String name, String email, String text) {		
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}	
	

}
