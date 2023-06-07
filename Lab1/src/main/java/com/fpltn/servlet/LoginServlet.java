package com.fpltn.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpltn.dao.AccountDao;
import com.fpltn.entities.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    // Validate the user's credentials against the database
	    Account user = AccountDao.findByUsernameAndPassword(username, password);

	    // If the user was found in the database, set session attributes and redirect to the appropriate page
	    if (user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);

	        // Set session attribute for role-specific access control
	        if (user.getRole().equals("Admin")) {
	            session.setAttribute("isAdmin", true);
	            response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
	        } else {
	            session.setAttribute("isAdmin", false);
	            session.setAttribute("userlogin", true);
	            response.sendRedirect(request.getContextPath() + "/main.jsp");
	        }
	    } else {
	        request.setAttribute("errorMessage", true);
	        response.sendRedirect(request.getContextPath() + "/login.jsp");
	    }
	}

}
