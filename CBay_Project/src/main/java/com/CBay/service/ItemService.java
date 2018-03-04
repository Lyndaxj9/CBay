package com.CBay.service;

import java.sql.Blob;

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
	
public static Integer addItemImage(Blob image, Integer ItemId) {
		
		ItemDao dao = new ItemDao();
		Image img = new Image(ItemId, image);
		dao.insertImage(img);
		return img.getId();
	}
	
	
	
	
	
	
	
	
	
}
