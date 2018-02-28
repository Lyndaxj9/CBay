package com.CBay.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.CBay.beans.User;

//-- represents the url to go to to get, 
//-- update, delete or insert information in 
//-- the database.
//-- example :
//-- http://localhost:8085/artificat-id/rest/user
@Path("/user")
public class UserApi {

	//-- this will return all the users in the database.
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllEmps(){
		return new ArrayList<User>();
	}
	
	//-- get one user from the database via id.
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getEmployeeIndex(@PathParam("id") int id){
		return new User();
	}
	
	//-- insert and if successful return success
	//-- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post")
	public String insertEmployee(User emp){
		return "success";
	}
}
