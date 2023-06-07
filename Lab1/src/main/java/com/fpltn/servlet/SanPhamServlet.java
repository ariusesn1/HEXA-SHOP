package com.fpltn.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.io.IOUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import org.hibernate.Session;

import com.fpltn.dao.DanhMucDao;
import com.fpltn.dao.SanPhamDao;
import com.fpltn.entities.Danhmuc;
import com.fpltn.entities.Sanpham;
import com.fpltn.util.HibernateUtil;

/**
 * Servlet implementation class SanPhamServlet
 */
@MultipartConfig
@WebServlet("/SanPhamServlet")
public class SanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamServlet() {
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

		SanPhamDao spDao = new SanPhamDao();

		List<Sanpham> danhSachSanpham = spDao.getSanpham();
		//danhSachDanhMuc.forEach(s -> System.out.println(s.getTendanhmuc())); // Xuất thử ra console

		// Tạo 1 HttpSession để qua trang index.jsp lấy dữ liệu
		javax.servlet.http.HttpSession session = request.getSession();

		// Thêm danhsachDanhMuc lấy từ Database vào Attribute đặt tên là listDM
		session.setAttribute("listSP", danhSachSanpham);
		response.sendRedirect("admin/sanpham.jsp");
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
		String masp = request.getParameter("masp");
		String tensp = request.getParameter("tensp");
		double giaban = Double.parseDouble(request.getParameter("giaban"));
		String mtngan = request.getParameter("mtngan");
		String chitiet = request.getParameter("chitiet");
		//String hinhanh = request.getParameter("hinhanh");
		int iddm = Integer.parseInt(request.getParameter("iddm"));
		
		String hinhanh = "";
		Part part = request.getPart("hinhanh");
		
		String realPath = request.getServletContext().getRealPath("/hinhanhs");
		hinhanh = Path.of(part.getSubmittedFileName()).getFileName().toString();
		
		if (!Files.exists(Path.of(realPath))) {
			Files.createDirectories(Path.of(realPath));
		}

		part.write(realPath + "/" + hinhanh);	

		Sanpham sp = new Sanpham();
		sp.setMasp(masp);
		sp.setTensp(tensp);
		sp.setGiaban(giaban);
		sp.setMotangan(mtngan);
		sp.setChitiet(chitiet);
		sp.setHinhanh(hinhanh);
		sp.setIddanhmuc(iddm);
		


		Session hbsession = HibernateUtil.getSessionFactory().openSession();
		hbsession.beginTransaction();

		hbsession.save(sp);

		hbsession.getTransaction().commit();
		
		doGet(request, response);
	}

}
