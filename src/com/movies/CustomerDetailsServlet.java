package com.movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerDetailsServlet
 */
// @WebServlet("/CustomerDetailsServlet")
public class CustomerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String seatsNeeded=request.getParameter("noofseatstobebooked");
		String mname=request.getParameter("mname");
		String customername= request.getParameter("customername");
		String customercontact= request.getParameter("customercontact");
		String customeraddress= request.getParameter("customeraddress");
		CustomerDetails md = new CustomerDetails();
		md.setCustomername(customername);
		md.setMoviename(mname);
		md.setNoofseatstobebooked(seatsNeeded);
		md.setCustomeraddress(customeraddress);
		md.setCustomercontact(customercontact);
		request.setAttribute("md", md);
		HttpSession sess = request.getSession();
		MovieList ml = (MovieList)sess.getAttribute("movlist");
		HashMap<Integer,MovieDetails> hm= ml.getList();
		CheckCustDetails c1 =new CheckCustDetails();
		c1.getMovieDetails(hm,mname);

		int noofseatsreq =Integer.parseInt(seatsNeeded);
		if(c1.checkavailabilityofSeats(noofseatsreq))
		{
			
			request.getRequestDispatcher("Bookticket.jsp").include(request, response);
		}
		else
		{
			request.getRequestDispatcher("NoSeatsAvailable.jsp").include(request, response);
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
