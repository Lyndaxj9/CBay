package com.CBay.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.util.HibernateUtil;

public class UserDao {

	public void insertUser(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		// INSERT USERS HERE
		
		
		tx.commit();
		session.close();
		
		session = HibernateUtil.getSession();
	}
}
