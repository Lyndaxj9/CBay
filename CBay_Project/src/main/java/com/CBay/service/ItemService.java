package com.CBay.service;


import java.io.FileOutputStream;
import java.util.List;

import com.CBay.beans.Image;
import com.CBay.beans.Item;
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
	
	
	
	/*
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
	
	
	
	
	
	
	
}
