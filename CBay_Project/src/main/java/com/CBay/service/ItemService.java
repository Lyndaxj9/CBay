package com.CBay.service;

import com.CBay.beans.Item;
import com.CBay.dao.ItemDao;

public class ItemService {

	public static Integer createItem(Integer SellerId, String ItemName, String Description, Integer Price) {
		
		ItemDao dao = new ItemDao();
		Item item = new Item(SellerId, ItemName, Description, Price, 0);
		dao.insertItem(item);
		return item.getId();
	}
	
	
	
	
	
	
	
	
	
}
