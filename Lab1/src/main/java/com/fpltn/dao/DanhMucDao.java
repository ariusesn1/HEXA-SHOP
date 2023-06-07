package com.fpltn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fpltn.entities.Danhmuc;
import com.fpltn.util.HibernateUtil;

public class DanhMucDao {
	// Tạo hàm thêm
	public static void saveDanhMuc(Danhmuc dm) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the danh muc object
			session.save(dm);
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
	public static List<Danhmuc> getDanhMuc() {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("select danhmuc from Danhmuc as danhmuc", Danhmuc.class).list();
		}
	}
	
	//Phân trang dữ liệu
	public static List<Danhmuc> getDanhMuc(int viTri, int soLuong) {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
		  Query query = session.createQuery("select danhmuc from Danhmuc as danhmuc", Danhmuc.class);
		  query.setFirstResult(viTri);
		  query.setMaxResults(soLuong);
		  return query.list();
		}
	}
	
	public static long DemSoLuongDanhMuc() {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
		  String countQ = "Select count (danhmuc.id) from Danhmuc danhmuc";
		  Query countQuery = session.createQuery(countQ);
		  return (Long) countQuery.uniqueResult();
		}
	}

	
	//Tìm kiếm và Phân trang dữ liệu
		public static List<Danhmuc> timKiem(String tuKhoa) {
			try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
			  Query query = session.createQuery(
					  "select danhmuc from Danhmuc as danhmuc "
			  		+ "where danhmuc.tendanhmuc LIKE :tendanhmuc ", Danhmuc.class);
			  query.setParameter("tendanhmuc", "%" + tuKhoa + "%");
			  return query.list();
			}
		}
		
	//Lấy danh mục theo id
	public static Danhmuc findById(int id) {	
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {		
			Danhmuc dm = session.load(Danhmuc.class, id);
			System.out.print(dm);
			return dm;
		} 
			
	}
	
	//xóa danh mục theo ID
	public static void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			Danhmuc dm = session.load(Danhmuc.class, id);
			session.delete(dm);
			
			
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
	public static void update(Danhmuc dm) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			
			session.update(dm);			
			
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
