package com.CBay.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.util.HibernateUtil;

public class ItemDao {

	public void insertItem(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		// INSERT ITEM HERE
		
		
		tx.commit();
		session.close();
		
		session = HibernateUtil.getSession();
	}
}
