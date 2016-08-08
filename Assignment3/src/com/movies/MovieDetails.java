package com.movies;

public class MovieDetails {
	String theatreName;
	String movieName;
	String seats;
	String startTime;
	String endTime;

	public MovieDetails() {

	}

	public MovieDetails(String theatreName, String movieName, String seats, String startTime, String endTime) {
		this.theatreName = theatreName;
		this.movieName = movieName;
		this.seats = seats;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "MovieDetails [theatreName=" + theatreName + ", movieName=" + movieName + ", seats=" + seats
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
