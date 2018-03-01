package com.CBay.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.beans.User;
import com.CBay.util.HibernateUtil;

public class UserDao {

	public void insertUser(User user){
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	//Integer user_id = null;
	try{
		//Open a transaction stream for our session.
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		
	}catch(HibernateException e){
		if(tx!=null){
			tx.rollback();
		}
		e.printStackTrace();
	}finally{
		session.close();
	}
	}
}
