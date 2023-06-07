package com.fpltn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.fpltn.dao.AccountDao;
import com.fpltn.dao.SanPhamDao;
import com.fpltn.entities.Account;
import com.fpltn.entities.Sanpham;
import com.fpltn.util.HibernateUtil;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session hbsession = HibernateUtil.getSessionFactory().openSession();
		hbsession.beginTransaction();

		AccountDao accDao = new AccountDao();

		List<Account> danhSachAccount = accDao.getAccount();
		//danhSachDanhMuc.forEach(s -> System.out.println(s.getTendanhmuc())); // Xuất thử ra console

		// Tạo 1 HttpSession để qua trang index.jsp lấy dữ liệu
		javax.servlet.http.HttpSession session = request.getSession();

		// Thêm danhsachDanhMuc lấy từ Database vào Attribute đặt tên là listDM
		session.setAttribute("listAcc", danhSachAccount);
		response.sendRedirect("admin/account.jsp");
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
	
		Account acc = new Account();
		acc.setUsername(username);
		acc.setPassword(password);
		acc.setEmail(email);
		acc.setRole(role);
		

		// Tạo 1 Hibernate Session từ HibernateUtil
		Session hbsession = HibernateUtil.getSessionFactory().openSession();
		hbsession.beginTransaction();

		// Lưu danh mục đã tạo ở trên
		hbsession.save(acc);

		hbsession.getTransaction().commit();
		
		doGet(request, response);
	}

}
