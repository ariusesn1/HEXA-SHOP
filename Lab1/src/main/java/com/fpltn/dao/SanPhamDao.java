package com.fpltn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fpltn.entities.Danhmuc;
import com.fpltn.entities.Sanpham;
import com.fpltn.util.HibernateUtil;

public class SanPhamDao {
	// Tạo hàm thêm
	public static void saveSanPham(Sanpham sp) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the danh muc object
			session.save(sp);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// Tạo hàm lấy dữ liệu
	public static List<Sanpham> getSanpham() {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("select sanpham from Sanpham as sanpham", Sanpham.class).list();
		}
	}
	
	
	
	//Phân trang dữ liệu
	public static List<Sanpham> getSanpham(int viTri, int soLuong) {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
		  Query query = session.createQuery("select sanpham from Sanpham as sanpham", Sanpham.class);
		  query.setFirstResult(viTri);
		  query.setMaxResults(soLuong);
		  return query.list();
		}
	}
	
	public static List<Sanpham> getSanphamPriceUp(int viTri, int soLuong) {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
		  Query query = session.createQuery("select sanpham from Sanpham as sanpham where sanpham.giaban > 0 ORDER BY giaban ASC", Sanpham.class);
		  query.setFirstResult(viTri);
		  query.setMaxResults(soLuong);
		  return query.list();
		}
	}
	
	public static List<Sanpham> getSanphamPriceDown(int viTri, int soLuong) {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
		  Query query = session.createQuery("select sanpham from Sanpham as sanpham where sanpham.giaban > 0 ORDER BY giaban DESC", Sanpham.class);
		  query.setFirstResult(viTri);
		  query.setMaxResults(soLuong);
		  return query.list();
		}
	}
	
	public static long DemSoLuongSanpham() {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
		  String countQ = "Select count (sanpham.id) from Sanpham sanpham";
		  Query countQuery = session.createQuery(countQ);
		  return (Long) countQuery.uniqueResult();
		}
	}

	
	//Tìm kiếm và Phân trang dữ liệu
	public static List<Sanpham> timKiem(String tuKhoa,int viTri,int soLuong) {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
		  Query query = session.createQuery(
				  "select sanpham from Sanpham as sanpham "
		  		+ "where sanpham.tensp LIKE :tensp ", Sanpham.class);
		  query.setParameter("tensp", "%" + tuKhoa + "%");
		  query.setFirstResult(viTri);
		  query.setMaxResults(soLuong);
		  return query.list();
		}
	}
	
	
	public static Long getTotalByKeyword(String keyword) {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
			  Query query = session.createQuery("select count(id) from Sanpham sp where sp.tensp like :tensp");
			  query.setParameter("tensp", "%" + keyword + "%");
			  return (Long) query.getSingleResult();
			}
	}
		
	//Lấy danh mục theo id
	public static Sanpham findById(int id) {	
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {		
			Sanpham sp = session.load(Sanpham.class, id);
			System.out.print(sp);
			return sp;
		} 
			
	}
	
	//xóa danh mục theo ID
	public static void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			Sanpham sp = session.load(Sanpham.class, id);
			session.delete(sp);
			
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	//Cập nhật danh mục
	public static void update(Sanpham sp) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			
			session.update(sp);			
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	  }
	
	//Phân trang 
	
}
