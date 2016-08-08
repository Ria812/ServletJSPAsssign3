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
 * Servlet Filter implementation class ValidateCustomerFilter
 */
@WebFilter("/ValidateCustomerFilter")
public class ValidateCustomerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidateCustomerFilter() {
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
		String cname = request.getParameter("customername"); 
		String addr = request.getParameter("customeraddress"); 
		String contact = request.getParameter("customercontact"); 
		
		String nseats = request.getParameter("noofseatstobebooked"); 
		Validate v = new Validate();
		if(v.checkName(cname)&& v.checkAddress(addr)&& v.checkPhone(contact) && v.checkNSeats(nseats))
		{
			chain.doFilter(request, response);
		}
		else
		{
			response.setContentType("text/html");
			out.println("You must have left the field empty or entered incorrect format!");
			out.println("Enter your details again!");
			request.getRequestDispatcher("CustomerDetails.jsp").include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
