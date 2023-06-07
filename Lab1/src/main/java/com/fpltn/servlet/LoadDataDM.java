package com.fpltn.servlet;

import java.io.IOException;
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
 * Servlet implementation class LoadDataDM
 */
@WebServlet("/LoadDataDM")
public class LoadDataDM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDataDM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("utf-8");
		}
		response.setContentType("text/json; charset=UTF-8");
		
		
		//Tạo 1 Hibernate Session từ HibernateUtil
		Session hbsession = HibernateUtil.getSessionFactory().openSession();
		hbsession.beginTransaction();
		
		//Load danh sách danh mục
//		List < Danhmuc > danhSachDanhMuc = DanhMucDao.getDanhMuc();
//		danhSachDanhMuc.forEach(s -> System.out.println(s.getTendm())); //Xuất thử ra console
//		
//		//Tạo 1 HttpSession để qua trang index.jsp lấy dữ liệu
//		javax.servlet.http.HttpSession session = request.getSession();
//		
//		//Thêm danhsachDanhMuc lấy từ Database vào Attribute đặt tên là listDM
//		session.setAttribute("listDM", danhSachDanhMuc);
		
		//Lấy 1 danh mục id = 2
		Danhmuc dm = DanhMucDao.findById(2);
		javax.servlet.http.HttpSession session = request.getSession();
		session.setAttribute("dm2", dm);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
