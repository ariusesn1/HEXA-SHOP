package com.fpltn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.fpltn.dao.DanhMucDao;
import com.fpltn.entities.Danhmuc;
import com.fpltn.util.HibernateUtil;

/**
 * Servlet implementation class DanhMucServlet
 */
@WebServlet("/DanhMucServlet")
public class DanhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhMucServlet() {
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

		DanhMucDao dmDao = new DanhMucDao();

		List<Danhmuc> danhSachDanhMuc = dmDao.getDanhMuc();
		//danhSachDanhMuc.forEach(s -> System.out.println(s.getTendanhmuc())); // Xuất thử ra console

		// Tạo 1 HttpSession để qua trang index.jsp lấy dữ liệu
		javax.servlet.http.HttpSession session = request.getSession();

		// Thêm danhsachDanhMuc lấy từ Database vào Attribute đặt tên là listDM
		session.setAttribute("listDM", danhSachDanhMuc);
		response.sendRedirect("admin/danhmuc.jsp");
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


		String tendm = request.getParameter("tendm");
		String mota = request.getParameter("mota");

		Danhmuc dm = new Danhmuc();
		dm.setTendanhmuc(tendm);
		dm.setMota(mota);

		// Tạo 1 Hibernate Session từ HibernateUtil
		Session hbsession = HibernateUtil.getSessionFactory().openSession();
		hbsession.beginTransaction();

		// Lưu danh mục đã tạo ở trên
		hbsession.save(dm);

		hbsession.getTransaction().commit();
		
		doGet(request, response);
	}

}
