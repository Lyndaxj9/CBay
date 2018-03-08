package com.CBay.service;

import java.util.List;

import com.CBay.beans.Order;
import com.CBay.beans.Transactions;
import com.CBay.dao.OrderDao;

public class OrderService {

	public static Integer createOrder(Integer BuyerId, Integer ItemTotal) {
		
		OrderDao dao = new OrderDao();
		Order order = new Order(BuyerId, ItemTotal, "Created");
		dao.insertOrder(order);
		return order.getId();
	}
	
	
	public static Integer createTransaction(Integer ItemId, Integer BuyerId, Integer SellerId, String Status, Integer Quantity) {
			
		OrderDao dao = new OrderDao();
		Transactions tran = new Transactions(ItemId, BuyerId, SellerId, "In-Chart", Quantity);
		dao.insertTransaction(tran);
		return tran.getId();
	}
	
	public static void updateTransactionCheckedOut(Integer TransactionId) {
		
		OrderDao dao = new OrderDao();
		dao.updateTransactionStatus(TransactionId, "Checked-Out");
	}
	
	public static void updateTransactionShipped(Integer TransactionId) {
			
			OrderDao dao = new OrderDao();
			dao.updateTransactionStatus(TransactionId, "Shipped");
	}
	
	public static void updateTransactionDelivered(Integer TransactionId) {
		
		OrderDao dao = new OrderDao();
		dao.updateTransactionStatus(TransactionId, "Delivered");
	}
	
	public static Order getOrderById(Integer OrderId){
		
		OrderDao dao = new OrderDao();
		return dao.getOrderById(OrderId);
	}
	
	public static List<Order> getAllOrders(){
		
		OrderDao dao = new OrderDao();
		return dao.getAllOrders();
	}
	
	public static List<Transactions> getAllTransactions(){
			
		OrderDao dao = new OrderDao();
		return dao.getAllTransactions();
	}
		
	public static List<Transactions> getTransactionsByOrderId(Integer OrderId){
		
		OrderDao dao = new OrderDao();
		return dao.getAllTransactionByOrder(OrderId);
	}
	
	public static void addOrderIdToTransaction(Integer TransactionId, Integer OrderId){
		
		OrderDao dao = new OrderDao();
		dao.insertOrderIdIntoTransaction(TransactionId, OrderId);;
	}
	
	public static void removeTransaction(Integer TransactionId){
		
		OrderDao dao = new OrderDao();
		dao.removeTransaction(TransactionId);

	}
	
	
}
