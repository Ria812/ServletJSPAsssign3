package com.movies;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class MovieList {
	HashMap<Integer, MovieDetails> hmap = new HashMap<Integer, MovieDetails>();
	private HttpServletRequest request;
	public int size = 1;
	MovieDetails moviedetails;

	public MovieList() {

	}

	public void setValues(MovieDetails md) {
		this.moviedetails = md;

	}

	public HashMap<Integer, MovieDetails> getList() {
		return hmap;
	}

	public boolean addToMap() {
		if (size <=10) {
			hmap.put(size, moviedetails);
			System.out.println("hmap");
			size++;
			return true;
		} 
		else
			return false;
	}

	public void deletemovieshow(int x) {
		hmap.remove(x);
		size--;
	}

}
