package com.fpltn.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.fpltn.dao.DanhMucDao;
import com.fpltn.dao.SanPhamDao;
import com.fpltn.util.HibernateUtil;

/**
 * Servlet implementation class DeleteSanPham
 */
@WebServlet("/DeleteSanPham")
public class DeleteSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSanPham() {
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
		
		int idsp = Integer.parseInt(request.getParameter("id"));
		SanPhamDao spDao = new SanPhamDao();
		spDao.delete(idsp);
		hbsession.close();
		response.sendRedirect(request.getContextPath() + "/admin/sanpham.jsp");
		//RequestDispatcher rd = request.getRequestDispatcher("sanpham");
		//rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
