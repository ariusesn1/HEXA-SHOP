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
import com.fpltn.util.HibernateUtil;

/**
 * Servlet implementation class DeleteDanhMuc
 */
@WebServlet("/deletedm")
public class DeleteDanhMuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDanhMuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Tạo 1 Hibernate Session từ HibernateUtil
		Session hbsession = HibernateUtil.getSessionFactory().openSession();
		hbsession.beginTransaction();
		
		int iddm = Integer.parseInt(request.getParameter("id"));
		DanhMucDao dmDao = new DanhMucDao();
		dmDao.delete(iddm);
		hbsession.close();
		response.sendRedirect(request.getContextPath() + "/admin/danhmuc.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
