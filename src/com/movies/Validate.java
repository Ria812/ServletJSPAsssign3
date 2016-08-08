package com.movies;

public class Validate {
	public boolean checkName(String name){
		if(name.equals(" ") || !name.matches("[A-Z][a-zA-Z]*") )
		{
		return false;
		}
		return true;
		
	}
	public boolean checkSeats(String seats){
		if(seats.equals(" ")|| !seats.matches("\\d{2}" ))
		{
		return false;
		}
		return true;
	}
	public boolean checkTime(String time){
		if(time.equals(" ")|| !time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]" ))
		{
		return false;
		}
		return true;
	}
	public boolean checkAddress(String address){
		if(address.equals(" ")|| !address.matches( "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" ))
		{
		return false;
		}
		return true;
	}
	public boolean checkPhone(String contact){
		if(contact.equals(" ")|| !contact.matches("\\d{10}"))
		{
		return false;
		}
		return true;
	}
	public boolean checkNSeats(String nseats){
		if(nseats.equals(" ")|| !nseats.matches("\\d{1}" ))
		{
		return false;
		}
		return true;
	}
}
