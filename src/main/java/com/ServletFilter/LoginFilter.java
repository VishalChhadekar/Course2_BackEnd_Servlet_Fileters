package com.ServletFilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "LoginFilter", urlPatterns = { "/DashboardServlet", "/ProfileServlet" })
public class LoginFilter implements Filter {
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		System.out.println("Login filter-checking userId");

		if (userId != null && userId.equals("johndoe")) {
			System.out.println("Login filter--User  is Admin, allow access to servlet");
			chain.doFilter(request, response);// redirecting to servlet
			System.out.println("After processing servlet");
		} else {
			out.println("You are not existing user, Please log in first");
			System.out.println("Invalid user entry, trying to access secure page");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}