package com.CBay.api;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.CBay.beans.Order;
import com.CBay.beans.Transactions;
import com.CBay.service.OrderService;

//-- represents the url to go to to get, 
//-- update, delete or insert information in 
//-- the database.
//-- example :
//-- http://34.217.96.20:8089/CBay/rest/order
@Path("/order")
public class OrderApi {

	// -- this will return all the item in the database.
	// -- past in below for testing.
	// -- http://34.217.96.20:8089/CBay/rest/order/get/all
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getAllOrders() {
		return OrderService.getAllOrders();
	}

	// -- get one item from the database via id.
	// -- {id} = 3
	// -- http://34.217.96.20:8089/CBay/rest/order/get/{id}
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrderIndex(@PathParam("id") int id) {
		return OrderService.getOrderById(id);
	}

	// -- this will return all the item in the database.
	// -- past in below for testing.
	// -- http://34.217.96.20:8089/CBay/rest/order/get/all
	@GET
	@Path("/get/cart/{id}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transactions> getAllTransInCart(@PathParam("id") int id, @PathParam("status") String status) {
		return OrderService.getTransactionByBuyerIdAndStatus(id, status);
	}

	/*
	 * This will have to be altered depending on how we will list the transactions
	 * from the in-cart page TO PASS THE TRANASACTIONS ID'S OF ALL ITEMS
	 * TRANSACTIONS TO BE CHECKED OUT.
	 */
	// -- insert and if successful return id
	// -- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post")
	public Integer insertOrder(JsonObject json){
		System.out.println(json);
		JsonArray jarr = json.getJsonArray("transactionlist");
		ArrayList<Integer> ali = new ArrayList<>();
		
		for(int i = 0; i < jarr.size(); i++) {
			ali.add(jarr.getInt(i));
		}

		Integer id = OrderService.placeOrder(ali, json.getInt("id"));
		return id;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/update/removefromchart/{id}")
	public String RemoveFromCart(@PathParam("id") Integer TransactionId) {
		OrderService.removeTransaction(TransactionId);
		return "success";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/update/shipped/{id}")
	public String OrderShipped(@PathParam("id") Integer TransactionId) {
		OrderService.updateTransactionShipped(TransactionId);
		return "success";
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/update/delivered/{id}")
	public String OrderDelivered(@PathParam("id") Integer TransactionId) {
		OrderService.updateTransactionDelivered(TransactionId);
		return "success";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/update/canceled/{id}")
	public String OrderCanceled(@PathParam("id") Integer TransactionId) {
		OrderService.updateTransactionCanceled(TransactionId);
		return "success";
	}

	// -- insert and if successful return success
	// -- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post/tocart")
	public String addToCart(JsonObject json) {
		System.out.println("to cart " + json);
		OrderService.createTransaction(json.getInt("itemid"), json.getInt("buyerid"), json.getInt("sellerid"),
				json.getInt("quantity"));
		return "success";
	}

	// -- delete a particular order via id.
	// -- if the message exist the return success
	// -- else just return error.
	// -- {id} = 3
	// -- http://34.217.96.20:8089/CBay/rest/order/delete/{id}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public String deleteOrder(@PathParam("id") int id) {
		return "success";
	}
}