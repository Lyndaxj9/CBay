package com.CBay.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.util.HibernateUtil;

public class OrderDao {

	public void insertOrder(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		// INSERT ORDER HERE
		
		
		tx.commit();
		session.close();
		
		session = HibernateUtil.getSession();
	}
}
