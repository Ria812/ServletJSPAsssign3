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
 * Servlet implementation class BookTicketServlet
 */
//@WebServlet("/BookTicketServlet")
public class BookTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		HttpSession sess= request.getSession(false);
		PrintWriter out = response.getWriter();
        CustomerDetails md2=(CustomerDetails) sess.getAttribute("md");
        request.setAttribute("md2", md2);	
		if(sess != null)
		{
		   if(request.getParameter("proccedtoticket")!= null && sess.getAttribute("custlist") == null)
		      {
			   { 
				   CheckCustDetails m1=new CheckCustDetails();
			          m1.setValues(md2);
			    	  m1.addToCustomerMap();
			    	  out.println("Ticket Booked");
			    	   sess.setAttribute("custlist", m1);
				       request.getRequestDispatcher("DisplayBookingHistory.jsp").include(request, response);

			      }
		      }
		    
		   else
		   {
			   
			   if(request.getParameter("proccedtoticket")!= null)
			   {
				  // System.out.println("abcd");
				   CheckCustDetails m2 = (CheckCustDetails)sess.getAttribute("custlist");
			        m2.setValues(md2);
			      m2.addToCustomerMap();
			       
	    	        out.println("Show Booked");
	    	        sess.setAttribute("custlist", m2);
				   request.getRequestDispatcher("DisplayBookingHistory.jsp").include(request, response);
				    
			      }
		   }
		}

		else
		{   out.println("You need to Login First");
			response.sendRedirect("UserLogin.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
