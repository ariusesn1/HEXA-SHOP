package com.fpltn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.fpltn.entities.Account;
import com.fpltn.util.HibernateUtil;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("utf-8");
		}
		response.setContentType("text/json; charset=UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
	
		Account acc = new Account();
		acc.setUsername(username);
		acc.setPassword(password);
		acc.setEmail(email);
		acc.setRole("User");
		

		// Tạo 1 Hibernate Session từ HibernateUtil
		Session hbsession = HibernateUtil.getSessionFactory().openSession();
		hbsession.beginTransaction();

		// Lưu danh mục đã tạo ở trên
		hbsession.save(acc);

		hbsession.getTransaction().commit();
		
		doGet(request, response);
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

}
