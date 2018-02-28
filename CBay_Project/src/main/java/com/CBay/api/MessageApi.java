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

import com.CBay.beans.Message;

//-- represents the url to go to to get, 
//-- update, delete or insert information in 
//-- the database.
//-- example :
//-- http://34.217.96.20:8089/CBay/rest/message
@Path("/message")
public class MessageApi {

	//-- this will return all the item in the database.
	//-- past in below for testing.
	//-- http://34.217.96.20:8089/CBay/rest/message/get/all
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(){
		return new ArrayList<Message>();
	}
	
	//-- get one item from the database via id.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/message/get/{id}
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageIndex(@PathParam("id") int id){
		return new Message();
	}
	
	//-- insert and if successful return success
	//-- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post")
	public String insertMessage(Message message){
		return "success";
	}
	
	//-- delete a particular item via id.
	//-- if the message exist the return success
	//-- else just return error.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/message/delete/{id}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public String deleteMessage(@PathParam("id") int id){
		return "success";
	}
}
