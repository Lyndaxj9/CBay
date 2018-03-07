package com.CBay.service;

import com.CBay.beans.Order;
import com.CBay.beans.Transactions;
import com.CBay.dao.OrderDao;

public class OrderService {

	public static Integer createOrder(Integer BuyerId, Integer ItemTotal) {
		
		OrderDao dao = new OrderDao();
		Order order = new Order(BuyerId, ItemTotal, "Pending");
		dao.insertOrder(order);
		return order.getId();
	}
	
	
	public static Integer createTransaction(Integer ItemId, Integer BuyerId, Integer SellerId, String Status, Integer Quantity) {
			
		OrderDao dao = new OrderDao();
		Transactions tran = new Transactions(ItemId, BuyerId, SellerId, Status, Quantity);
		dao.insertTransaction(tran);
		return tran.getId();
	}
	
	
	// list of order and their status
	
	// change status of the order, with that change the status of each transaction 
	
	// set status of transactions to in cart, ordered, shipped and delivered
	
	// git all orders for the Admin and Mod to see
	
}
