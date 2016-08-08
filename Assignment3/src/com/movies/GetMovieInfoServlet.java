package com.movies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetMovieInfoServlet
 */
// @WebServlet("/GetMovieInfoServlet")
public class GetMovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMovieInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String movie = request.getParameter("moviename");
		String theatre = request.getParameter("theatrename");
		String seats = request.getParameter("seatsavailable");
		String stime = request.getParameter("starttime");
		String etime = request.getParameter("endtime");
		MovieDetails detail = new MovieDetails();
		detail.setMovieName(movie);
		detail.setTheatreName(theatre);
		detail.setSeats(seats);
		detail.setStartTime(stime);
		detail.setEndTime(etime);

		HttpSession ses = request.getSession(false);
		if (ses != null) 
		{
			if (request.getParameter("addShow") != null && ses.getAttribute("movlist") == null) 
			{
				MovieList list1 = new MovieList();
				list1.setValues(detail);
				if (list1.addToMap()) 
				{
					out.println("Show is added");
					ses.setAttribute("movlist", list1);
					request.getRequestDispatcher("EnterMovieDetails.jsp").include(request, response);

				}

			} else 
			{
				if (request.getParameter("addShow") != null) {
					MovieList list2 = (MovieList) ses.getAttribute("movlist");
					list2.setValues(detail);
					if (list2.addToMap())
					{
						out.println("Show is added");
						ses.setAttribute("movlist", list2);
						request.getRequestDispatcher("EnterMovieDetails.jsp").include(request, response);
					}
					else 
					{
						request.getRequestDispatcher("ShowError.jsp").include(request, response);

					}
				}
			}

		} else {
			out.println("You need to Login!");
			response.sendRedirect("UserLogin.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
