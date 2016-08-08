<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h3>Welcome!</h3>
<h3>Fill the fields to Add your show</h3>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<form action="GetMovieInfoServlet" method="post">
		<br>
		<br> Enter the Movie Name:<input type="text" name="moviename"><br>
		<br> Enter the Theatre Name:<input type="text" name="theatrename"><br>
		<br> Enter the Seats available:<input type="text" name="seatsavailable"><br>
		<br> Enter the Start Time:<input type="text" name="starttime"><br>
		<br> Enter the End Time:<input type="text" name="endtime"><br>
		<br> <input type="submit" name="addShow" value="Add Show"><br>
		<br> <a href="http://localhost:8085/Assignment3/DisplayAllMoviesServlet">Display
			all movie shows</a>
			
			

		<%-- <jsp:useBean id ="moviedetails" class="com.movies.MovieDetails" scope="session"></jsp:useBean> --%>
		<%-- <jsp:setProperty property="*" name="moviedetails"/> --%>
	</form>
	<form action="Home.jsp" method="post">
		<input type="Submit" value="Back" >
		</form>
		
		<form action="Logout.jsp" method="post">
		<input type="Submit" value="Logout" >
		</form>
</body>

</body>
</html>