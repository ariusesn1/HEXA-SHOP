package com.fpltn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		// Create the SessionFactory from hibernate.cfg.xml
		return new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
