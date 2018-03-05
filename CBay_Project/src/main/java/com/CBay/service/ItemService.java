package com.CBay.service;


import java.util.List;

import com.CBay.beans.Image;
import com.CBay.beans.Item;
import com.CBay.beans.ItemRating;
import com.CBay.beans.User;
import com.CBay.dao.ItemDao;

public class ItemService {

	public static Integer createItem(Integer SellerId, String ItemName, String Description, Integer Price) {
		
		ItemDao dao = new ItemDao();
		Item item = new Item(SellerId, ItemName, Description, Price, 0);
		dao.insertItem(item);
		return item.getId();
	}
	
	public static Integer addItemImage(String FilePath, Integer ItemId) {

		ItemDao dao = new ItemDao();
		return dao.insertImage(FilePath, ItemId);
		
	}
	
	public static Item getItemById(Integer ItemId) {
		
		ItemDao dao = new ItemDao();
		return dao.getItemById(ItemId);
	}
	
	
	
	/*
	 * 
	 * to retrieve the Image from here, iterate through this list as following (In the API/Servlet level)
	 * 	
	 * 		for(Image img : ItemService.getImageByItemId(ItemID)) {
	 * 			FileOutputStream outputStream = new FileOutputStream("WHATEVER FILENAME IT WILL BE CALLED [SOMETHING.JPG]");
	 * 			outputStream.write(img.getImage());
	 * 			outputStream.close();
	 * 		}
	 * 
	 */
	public static List<Image> getImageByItemId(Integer ItemId) {
	
		ItemDao dao = new ItemDao();
		List<Image> image = dao.getItemImages(ItemId);
		
		return image;
	}
	
	
	public static Integer insertItemRating(Integer ItemID, Integer NumRating, String Comment) {
		
		ItemDao dao = new ItemDao();
		ItemRating rating = new ItemRating(ItemID, NumRating, Comment);
		
		dao.addItemRatingAndComment(rating); 
		return rating.getId();
		
	}
	
	
	public static void editItem(Integer ItemId, String ItemName, Integer Price, String Description) {
		
		ItemDao dao = new ItemDao();
		Item item = new Item(ItemId, ItemName, Price, Description);
		dao.changeItemInfo(item);
		
	
	}
	
	
	public static List<String> getItemComments(Integer ItemId){
		
		ItemDao dao = new ItemDao();
		List<String> comments = null;
		List<ItemRating> ratings = dao.getItemRating(ItemId);
		
		for (ItemRating r : ratings) {
			
			comments.add(r.getTextRating());
		}
		
		return comments;
	}
	
	
	public static List<Integer> getItemAverageRating(Integer ItemId){
			
			ItemDao dao = new ItemDao();
			List<Integer> avg = null;
			List<ItemRating> ratings = dao.getItemRating(ItemId);
			
			for (ItemRating r : ratings) {
				
				avg.add(r.getNumRating());
			}
			
			return avg;
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
