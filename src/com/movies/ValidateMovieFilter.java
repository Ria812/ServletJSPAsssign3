package com.movies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ValidateMovieFilter
 */
@WebFilter("/ValidateMovieFilter")
public class ValidateMovieFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidateMovieFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		PrintWriter out = response.getWriter();
		String mname = request.getParameter("moviename"); 
		String tname = request.getParameter("theatrename"); 
		String seats = request.getParameter("seatsavailable"); 
		String stime = request.getParameter("starttime"); 
		String etime = request.getParameter("endtime"); 
		Validate v = new Validate();
		if(v.checkName(mname)&& v.checkName(tname)&& v.checkSeats(seats) && v.checkTime(stime))
		{
			chain.doFilter(request, response);
		}
		else
		{
			response.setContentType("text/html");
			out.println("You must have left the field empty or entered incorrect format!");
			out.println("Enter your details again!");
			request.getRequestDispatcher("EnterMovieDetails.jsp").include(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
