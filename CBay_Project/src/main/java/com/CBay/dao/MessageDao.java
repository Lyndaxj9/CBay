package com.CBay.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.beans.Message;
import com.CBay.beans.MessageThread;
import com.CBay.beans.Order;
import com.CBay.beans.Transactions;
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
	
	
	public List<Message> getAllMessagesByThread(Integer ThreadId) {
		List<Message> msg = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{	
			tx = session.beginTransaction();
			String hql = "FROM Message WHERE ThreadID= :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", ThreadId);
			msg = query.list();
			return msg;
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	
	public List<MessageThread> getAllThreads() {
		List<MessageThread> thread = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{	
			tx = session.beginTransaction();
			thread = session.createQuery("FROM MessageThread").list();
			return thread;
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	
	public List<Message> getAllMessages() {
		List<Message> msg = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{	
			tx = session.beginTransaction();
			msg = session.createQuery("FROM Message").list();
			return msg;
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	
	public List<MessageThread> getAllThreadsByUser(Integer UserId) {
		List<MessageThread> thread = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{	
			tx = session.beginTransaction();
			String hql = "FROM MessageThread WHERE SenderId= :ID OR ResponderId= :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", UserId);
			thread = query.list();
			return thread;
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	
	public MessageThread getThreadById(Integer ThreadId) {
		MessageThread thread = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			
			thread = (MessageThread)session.get(MessageThread.class, ThreadId);
			
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return thread;
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
