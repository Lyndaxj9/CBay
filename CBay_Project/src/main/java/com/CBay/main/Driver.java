package com.CBay.main;

import java.util.Set;

import com.CBay.beans.Image;
import com.CBay.beans.Item;
import com.CBay.beans.Rating;
import com.CBay.beans.User;
import com.CBay.dao.ItemDao;

public class Driver {

	public static void main(String[] args) {

		ItemDao item = new ItemDao();
		//String name, String description, String email
		item.insertItem(new Item("TV", "Sansung TV", 250));
		item.insertItem(new Item("Phone", "Iphone", 250));
		
		
		//	public Item(User user, String name, String description, Set<Image> image, Integer price, Set<Rating> ratingAvg,
		//Set<Rating> ratingText) {
		System.exit(0);
	}

}
