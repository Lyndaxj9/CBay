package com.CBay.service;

import java.util.ArrayList;
import java.util.List;

import com.CBay.beans.Order;
import com.CBay.beans.Transactions;
import com.CBay.dao.OrderDao;

public class OrderService {

	
	// dont touch this method
	private static Integer createOrder(Integer BuyerId, Integer ItemTotal) {
		
		OrderDao dao = new OrderDao();
		Order order = new Order(BuyerId, ItemTotal, "Created");
		dao.insertOrder(order);
		
		return order.getId();
	}
	
	
	public static Integer createTransaction(Integer ItemId, Integer BuyerId, Integer SellerId, Integer Quantity) {
			
		OrderDao dao = new OrderDao();
		Transactions tran = new Transactions(ItemId, BuyerId, SellerId, "In-Cart", Quantity);
		dao.insertTransaction(tran);
		return tran.getId();
	}
	
	// dont touch this method
	private static void updateTransactionCheckedOut(Integer TransactionId) {
		
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
	
	public static void updateTransactionCanceled(Integer TransactionId) {
		
		OrderDao dao = new OrderDao();
		dao.updateTransactionStatus(TransactionId, "Canceled");
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
	
	
	
	public static void removeTransaction(Integer TransactionId){
		
		OrderDao dao = new OrderDao();
		dao.removeTransaction(TransactionId);

	}
	
	public static List<Transactions> getTransactionByBuyerIdAndStatus(Integer BuyerId, String Status){
		
		OrderDao dao = new OrderDao();

		List <Transactions> trans = new ArrayList<>();
		for (Transactions t : getAllTransactions()) {
			if (t.getBuyerId().equals(BuyerId) && t.getStatus().equals(Status)) {
				
				trans.add(dao.getTransactionById(t.getId()));
			}
		}
		
		return trans;
	}
	
	
	public static Integer placeOrder (List<Integer> TransactionsId, Integer BuyerId) {
		
		OrderDao dao = new OrderDao();
		Integer orderId = createOrder(BuyerId, TransactionsId.size());

		for(Integer tranId : TransactionsId) {
			
			dao.insertOrderIdIntoTransaction(tranId, orderId);
			updateTransactionCheckedOut(tranId);
		}
	
		return orderId;
	}
	
	public static List<Transactions> getAllTransactionsBySeller(Integer Seller) {
		
		OrderDao dao = new OrderDao();
		return dao.getAllTransactionsBySellerId(Seller);
		
		
	}
	
}
