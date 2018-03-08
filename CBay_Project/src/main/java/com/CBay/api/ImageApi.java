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

import com.CBay.beans.Image;
import com.CBay.service.ItemService;

//-- represents the url to go to to get, 
//-- update, delete or insert information in 
//-- the database.
//-- example :
//-- http://34.217.96.20:8089/CBay/rest/image
@Path("/image")
public class ImageApi {

	//-- this will return all the images in the database.
	//-- past in below for testing.
	//-- http://34.217.96.20:8089/CBay/rest/image/get/all
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Image> getAllImages(){
		return new ArrayList<Image>();
	}
	
	//-- get one user from the database via id.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/user/get/{id}
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Image getImageIndex(@PathParam("id") int id){
		return new Image();
	}
	
	//-- get one user from the database via id.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/user/get/{id}
	@GET
	@Path("/get/itemimage/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Image> getImageByItemId(@PathParam("id") int id){
		return ItemService.getImageByItemId(id);
	}
	
	//-- insert and if successful return success
	//-- if it is not return unsuccessful.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post")
	public String insertImage(Image image){
		return "success";
	}
	
	//-- delete a particular image via id.
	//-- if the image exist the return success
	//-- else just return error.
	//-- {id} = 3
	//-- http://34.217.96.20:8089/CBay/rest/image/delete/{id}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public String deleteImage(@PathParam("id") int id){
		return "success";
	}
}