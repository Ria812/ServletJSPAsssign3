package com.movies;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MovieTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse resp = (HttpServletResponse) pageContext.getResponse();
		HttpSession sess = pageContext.getSession();
		JspWriter out = pageContext.getOut();
		MovieList m2 = (MovieList) sess.getAttribute("movlist");
		HashMap<Integer, MovieDetails> h = m2.getList();
		if (h == null) {
			try {
				req.getRequestDispatcher("ErrorPage.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			out.write("<select name=\"mname\">");
			for (MovieDetails m : h.values()) {
				out.write("<option value=\"" + m.getMovieName() + "\">" + m.getMovieName() + "</option>");
			}
			out.write("</select>");
		}
	}
}
