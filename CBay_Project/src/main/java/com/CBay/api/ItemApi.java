package com.CBay.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.CBay.beans.Item;
import com.CBay.service.ItemService;

//-- represents the url to go to to get, 
//-- update, delete or insert information in 
//-- the database.
//-- example :
//-- http://34.217.96.20:8089/CBay/rest/item
@Path("/item")
public class ItemApi {
	
	//-- this will return all the item in the database.
	//-- past in below for testing.
	//-- http://34.217.96.20:8089/CBay/rest/item/get/all
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllItems(){
		return new ArrayList<Item>();
	}
	
	//-- get one item from the database via id.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/item/get/{id}
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItemIndex(@PathParam("id") int id){
		return ItemService.getItemById(id);
	}
	
	//-- insert and if successful return success
	//-- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post")
	public String insertItem(Item item){
		return "success";
	}
	
	//-- delete a particular item via id.
	//-- if the image exist the return success
	//-- else just return error.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/item/delete/{id}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public String deleteItem(@PathParam("id") int id){
		return "success";
	}

}