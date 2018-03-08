package com.CBay.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.beans.Item;
import com.CBay.beans.Order;
import com.CBay.beans.Transactions;
import com.CBay.util.HibernateUtil;

public class OrderDao {

	public void insertOrder(Order order){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
		
			session.save(order);
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

	public void insertTransaction(Transactions tran) {
	
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
		
			session.save(tran);
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
	
	public void insertOrderIdIntoTransaction(Integer TransactionId, Integer OrderId) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Transactions tran = null;
		try{
			tx = session.beginTransaction();
			tran = (Transactions)session.get(Transactions.class, TransactionId);
			tran.setOrderId(OrderId);
			session.update(tran);
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

	public void updateTransactionStatus(Integer Id, String Status) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Transactions tran = null;
		try{
			tx = session.beginTransaction();
			tran = (Transactions)session.get(Transactions.class, Id);
			
			if(Status.equals("Checked-Out")) {
				Item item = (Item)session.get(Item.class, tran.getItemId());
				item.setQuantity(item.getQuantity() - tran.getQuantity());
				session.update(item);
			}
			
			tran.setStatus(Status);
			session.update(tran);
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
	
	
	public void removeTransaction(Integer Id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Transactions tran = null;
		try{
			tx = session.beginTransaction();
			tran = (Transactions)session.get(Transactions.class, Id);
			session.delete(tran);
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
	
	
	public List<Transactions> getAllTransactionByOrder(Integer OrderID) {
		List<Transactions> trans = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{	
			tx = session.beginTransaction();
			String hql = "FROM Transactions WHERE OrderId= :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", OrderID);
			trans = query.list();
			return trans;
			
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
	
	
	public List<Order> getAllOrders() {
		List<Order> orders = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{	
			tx = session.beginTransaction();
			orders = session.createQuery("FROM Order").list();
			return orders;
			
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
	
	
	public List<Transactions> getAllTransactions() {
		List<Transactions> trans = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{	
			tx = session.beginTransaction();
			trans = session.createQuery("FROM Transactions").list();
			return trans;
			
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
	
	
	public Order getOrderById(Integer OrderId) {
		Order order = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			
			order = (Order)session.get(Order.class, OrderId);
			
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return order;
			
		}

	public Transactions getTransactionById(Integer TransactionId) {
		
		Transactions trans = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
			
			try{
				tx = session.beginTransaction();
				trans = (Transactions)session.get(Transactions.class, TransactionId);
				
			}catch(HibernateException e){
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}
			return trans;
				
	}
	
	

}