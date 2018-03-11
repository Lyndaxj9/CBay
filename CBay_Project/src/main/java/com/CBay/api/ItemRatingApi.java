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

import com.CBay.beans.ItemRating;


//-- represents the url to go to to get, 
//-- update, delete or insert information in 
//-- the database.
//-- example :
//-- http://34.217.96.20:8089/CBay/rest/itemrating
@Path("/itemrating")
public class ItemRatingApi {
	

		//-- this will return all the rating in the database.
		//-- past in below for testing.
		//-- http://34.217.96.20:8089/CBay/rest/itemrating/get/all
		@GET
		@Path("/get/all")
		@Produces(MediaType.APPLICATION_JSON)
		public List<ItemRating> getAllRatings(){
			return new ArrayList<ItemRating>();
		}
		
		//-- get one rating from the database via id.
		//-- {id} = 3
		//-- http://34.217.96.20:8089/CBay/rest/itemrating/get/{id}
		@GET
		@Path("/get/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public ItemRating getRatingIndex(@PathParam("id") int id){
			return new ItemRating();
		}
		
		//-- insert and if successful return success
		//-- if it is not return unsuccessful.
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		@Path("/post")
		public String insertRating(ItemRating rating){
			return "success";
		}
		
		//-- delete a particular user via id.
		//-- if the user exist the return success
		//-- else just return error.
		//-- {id} = 3
		//-- http://34.217.96.20:8089/CBay/rest/itemrating/delete/{id}
		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		@Path("/delete/{id}")
		public String deleteRating(@PathParam("id") int id){
			return "success";
		}
	}