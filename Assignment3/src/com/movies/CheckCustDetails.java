package com.movies;

import java.util.HashMap;

public class CheckCustDetails {
	int totalNumberOfSeats=0;
	HashMap<Integer,CustomerDetails> hc= new HashMap<Integer,CustomerDetails>();
	public int c_size=1;
	CustomerDetails customerDetails = new CustomerDetails();
	
	
     public void getMovieDetails(HashMap<Integer,MovieDetails> hm, String movieName)
     {   
    	 for(MovieDetails m: hm.values())
 		{
 			if(m.getMovieName().equals(movieName))
 			{
 				totalNumberOfSeats=Integer.parseInt(m.getSeats());
 				break;
 			}
 		}
     } 	
	public boolean checkavailabilityofSeats(int seats) 
	{
		if(seats<=totalNumberOfSeats)
		{
			//totalNumberOfSeats-=seats;
			return true;
		}
		else return false;
		
	}
	public void setValues(CustomerDetails m)
	{
		this.customerDetails=m;
	}
	public boolean addToCustomerMap()
	{   

		hc.put(c_size, customerDetails);
		c_size++;
		return true;
	 
	
	}
	


}
