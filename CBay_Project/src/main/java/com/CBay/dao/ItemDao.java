package com.CBay.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.beans.Image;
import com.CBay.beans.Item;
import com.CBay.util.HibernateUtil;

public class ItemDao {

	public void insertItem(Item item){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(item);
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

	public void insertImage(Image img) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(img);
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
