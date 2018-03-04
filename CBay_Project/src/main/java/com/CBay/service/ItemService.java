package com.CBay.service;


import java.util.List;

import com.CBay.beans.Item;
import com.CBay.beans.Order;
import com.CBay.dao.ItemDao;
import com.CBay.dao.UserDao;

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
	
	public static List<Image> getImageByItemId(Integer ItemId) {
			
			ItemDao dao = new ItemDao();
			return dao.getItemImages(ItemId);	
		}
	
	
	
	
	
	
	
}
