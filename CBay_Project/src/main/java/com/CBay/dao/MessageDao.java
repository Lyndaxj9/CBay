package com.CBay.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.beans.Message;
import com.CBay.beans.MessageThread;
import com.CBay.util.HibernateUtil;

public class MessageDao {

	
public void insertMessageThread(MessageThread thread){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		//Integer user_id = null;
		try{
			tx = session.beginTransaction();
		
			session.save(thread);
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



public void insertMessage(Message msg) {
	
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		//Integer user_id = null;
		try{
			tx = session.beginTransaction();
		
			session.save(msg);
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
