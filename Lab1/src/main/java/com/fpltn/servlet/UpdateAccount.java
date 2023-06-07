package com.fpltn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpltn.dao.AccountDao;
import com.fpltn.dao.SanPhamDao;
import com.fpltn.entities.Account;
import com.fpltn.entities.Sanpham;

/**
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccount() {
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
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("utf-8");
		}
		response.setContentType("text/json; charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String role = request.getParameter("role");

		Account acc = new Account();
		
		acc = AccountDao.findById(id);
		
		acc.setId(id);
		acc.setUsername(username);
		acc.setPassword(password);
		acc.setEmail(email);
		acc.setRole(role);
		
		
		AccountDao.update(acc);
		
				
		doGet(request, response);
		
		
		response.sendRedirect(request.getContextPath() + "/admin/account.jsp");
	}

}
