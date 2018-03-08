package com.CBay.api;

import java.util.ArrayList;
import java.util.List;

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
import com.CBay.service.OrderService;

//-- represents the url to go to to get, 
//-- update, delete or insert information in 
//-- the database.
//-- example :
//-- http://34.217.96.20:8089/CBay/rest/order
@Path("/order")
public class OrderApi {

	//-- this will return all the item in the database.
	//-- past in below for testing.
	//-- http://34.217.96.20:8089/CBay/rest/order/get/all
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getAllOrders(){
		return new ArrayList<Order>();
	}
	
	//-- get one item from the database via id.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/order/get/{id}
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrderIndex(@PathParam("id") int id){
		return new Order();
	}
	
	//-- insert and if successful return success
	//-- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post")
	public String insertOrder(Order message){
		return "success";
	}
	
	//-- insert and if successful return success
	//-- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post/tocart")
	public String addToCart(JsonObject json){
		System.out.println("to cart " + json);
		OrderService.createTransaction(json.getInt("itemid"), json.getInt("buyerid"), json.getInt("sellerid"), json.getInt("quantity"));
		return "success";
	}
	
	//-- delete a particular order via id.
	//-- if the message exist the return success
	//-- else just return error.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/order/delete/{id}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public String deleteOrder(@PathParam("id") int id){
		return "success";
	}
}