package com.fpltn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fpltn.entities.Account;
import com.fpltn.util.HibernateUtil;

public class AccountDao {
	public static void saveAccount(Account acc) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the danh muc object
			session.save(acc);
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
	public static List<Account> getAccount() {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("select account from Account as account", Account.class).list();
		}
	}
	
	//Phân trang dữ liệu
	public static List<Account> getAccount(int viTri, int soLuong) {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
		  Query query = session.createQuery("select account from Account as account", Account.class);
		  query.setFirstResult(viTri);
		  query.setMaxResults(soLuong);
		  return query.list();
		}
	}
	
	public static long DemSoLuongAccount() {
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
		  String countQ = "Select count (account.id) from Account account";
		  Query countQuery = session.createQuery(countQ);
		  return (Long) countQuery.uniqueResult();
		}
	}

	
	//Tìm kiếm và Phân trang dữ liệu
		public static List<Account> timKiem(String tuKhoa) {
			try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
			  Query query = session.createQuery(
					  "select account from Account as account "
			  		+ "where account.username LIKE :username ", Account.class);
			  query.setParameter("username", "%" + tuKhoa + "%");
			  return query.list();
			}
		}
		
	public static Account findById(int id) {	
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {		
			Account acc = session.load(Account.class, id);
			System.out.print(acc);
			return acc;
		} 
	}
	
	public static Account findByUsernameAndPassword(String username, String password) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Query<Account> query = session.createQuery("FROM Account WHERE username = :username AND password = :password");
	        query.setParameter("username", username);
	        query.setParameter("password", password);
	        List<Account> results = query.list();
	        if (results.size() == 1) {
	            return results.get(0);
	        }
	    }
	    return null;
	}
	
	public static void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			Account acc = session.load(Account.class, id);
			session.delete(acc);
			
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
	public static void update(Account acc) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			
			session.update(acc);			
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	  }
}
