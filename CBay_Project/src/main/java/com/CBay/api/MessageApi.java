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

import com.CBay.beans.Message;
import com.CBay.service.MessageService;

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
	
	//-- this will return all the item in the database.
	//-- past in below for testing.
	//-- http://34.217.96.20:8089/CBay/rest/message/get/all
	@GET
	@Path("/get/thread/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessagesByThread(@PathParam("id") int id){
		return MessageService.getAllMessagesByThread(id);
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
	public String insertMessage(JsonObject json){
		System.out.println("msg posted" + json);
		MessageService.SendMessage(json.getInt("thread"), json.getInt("transaction"), json.getInt("sender"), 
				json.getInt("responder"), json.getString("content"), json.getString("subject"));
		return "success";
	}
	
	//-- insert and if successful return success
	//-- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post/report")
	public String insertNewReportMsg(JsonObject json){
		System.out.println("msg report posted" + json);
		Integer threadid = MessageService.createMessageThread(json.getInt("sender"), json.getInt("responder"));
		MessageService.SendMessage(threadid, json.getInt("transaction"), json.getInt("sender"), 
				json.getInt("responder"), json.getString("content"), json.getString("subject"));
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
