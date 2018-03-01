package com.CBay.dao;

import java.util.List;

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

	public boolean LoginUser(String username, String password, String Type) {
		List<User> AllUsers = null;
		User user = null;
		boolean ValidLogin = false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			AllUsers = session.createQuery("FROM User").list();
			
			for (User u : AllUsers) {
				System.out.println(u.getUserName() + " " + u.getPW() + " " + u.getUserType());
				if((u.getUserName().equals(username)) && (u.getPW().equals(password)) && (u.getUserType().equals(Type)))
					return true;
				
			}
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}
}
