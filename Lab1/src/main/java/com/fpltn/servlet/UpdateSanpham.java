package com.fpltn.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fpltn.dao.DanhMucDao;
import com.fpltn.dao.SanPhamDao;
import com.fpltn.entities.Danhmuc;
import com.fpltn.entities.Sanpham;

/**
 * Servlet implementation class UpdateSanphamServlet
 */
@MultipartConfig
@WebServlet("/UpdateSanpham")
public class UpdateSanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSanpham() {
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

		int idsp = Integer.parseInt(request.getParameter("idsp"));
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
		
		Sanpham sp = new Sanpham();
		
		sp = SanPhamDao.findById(idsp);
		
		sp.setId(idsp);
		sp.setMasp(masp);
		sp.setTensp(tensp);
		sp.setGiaban(giaban);
		sp.setMotangan(mtngan);
		sp.setChitiet(chitiet);
		sp.setHinhanh(hinhanh);
		sp.setIddanhmuc(iddm);
		
		SanPhamDao.update(sp);
		
				
		doGet(request, response);
		
		response.sendRedirect("admin/sanpham.jsp");
	}

}
