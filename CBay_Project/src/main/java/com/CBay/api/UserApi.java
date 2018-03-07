package com.CBay.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.CBay.beans.Item;
import com.CBay.beans.User;
import com.CBay.service.UserService;

//-- represents the url to go to to get, 
//-- update, delete or insert information in 
//-- the database.
//-- example :
//-- http://34.217.96.20:8089/CBay/rest/user
@Path("/user")
public class UserApi {


	//-- this will return all the users in the database.
	//-- past in below for testing.
	//-- http://34.217.96.20:8089/CBay/rest/user/get/all
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers(){
		return new ArrayList<User>();
	}
	
	//-- get one user from the database via id.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/user/get/{id}
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserIndex(@PathParam("id") int id){
		return UserService.getUserInfo(id);
	}
	
	//-- get one user from the database via username, password, type
	//-- http://34.217.96.20:8089/CBay/rest/user/get/{username}/{password}/{type}
	@GET
	@Path("/get/{username}/{password}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Integer loginUser(@PathParam("username") String username, 
			@PathParam("password")String password, @PathParam("type")String type){
		return UserService.LoginSeller(username, password);
	}
	
	//-- insert and if successful return success
	//-- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post")
	public String insertUser(User user){
		return "success";
	}
	
	//-- delete a particular user via id.
	//-- if the user exist the return success
	//-- else just return error.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/user/delete/{id}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public String deleteUser(@PathParam("id") int id){
		return "success";
	}
}