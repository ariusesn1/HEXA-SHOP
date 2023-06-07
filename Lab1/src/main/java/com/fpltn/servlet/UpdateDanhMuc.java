package com.fpltn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpltn.dao.DanhMucDao;
import com.fpltn.entities.Danhmuc;

/**
 * Servlet implementation class UpdateDanhMuc
 */
@WebServlet("/UpdateDanhMuc")
public class UpdateDanhMuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDanhMuc() {
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
		String tendm = request.getParameter("tendm");
		String mota = request.getParameter("mota");

		Danhmuc dm = new Danhmuc();
		
		dm = DanhMucDao.findById(id);
		
		dm.setTendanhmuc(tendm);
		dm.setMota(mota);

		
		DanhMucDao.update(dm);
		
				
		doGet(request, response);
		
		response.sendRedirect("admin/danhmuc.jsp");
	}

}
