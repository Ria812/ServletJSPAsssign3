package com.movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ValidateUserFilter
 */
@WebFilter("/ValidateUserFilter")
public class ValidateUserFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ValidateUserFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		// place your code here
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		 
		HashMap<String, String> newMap = new HashMap<String, String>();
		newMap.put("Ria@gmail.com", "qwerty");
		newMap.put("Dipika@gmail.com", "asdfgh");
		newMap.put("Neha@gmail.com", "zxcvbn");
		if (newMap.containsKey(userName) && password.equals(newMap.get(userName))) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			response.setContentType("text/html");
			out.println("Login Unsuccessful! Incorrect Username or password.");
			request.getRequestDispatcher("UserLogin.jsp").include(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
