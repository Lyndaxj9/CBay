package com.CBay.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.CBay.beans.Image;
import com.CBay.beans.Item;
import com.CBay.beans.ItemRating;
import com.CBay.dao.ItemDao;

public class ItemService {

	public static Integer createItem(Integer SellerId, String ItemName, String Description, Double Price,
			Integer quantity) {

		ItemDao dao = new ItemDao();
		double price = new BigDecimal(Price).setScale(3, RoundingMode.HALF_UP).doubleValue();
		Item item = new Item(SellerId, ItemName, Description, price, quantity, 0.0);
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

	public static List<Item> getAllItems() {

		ItemDao dao = new ItemDao();
		return dao.getAllItems();
	}

	/*
	 * 
	 * to retrieve the Image from here, iterate through this list as following (In
	 * the API/Servlet level)
	 * 
	 * for(Image img : ItemService.getImageByItemId(ItemID)) { FileOutputStream
	 * outputStream = new
	 * FileOutputStream("WHATEVER FILENAME IT WILL BE CALLED [SOMETHING.JPG]");
	 * outputStream.write(img.getImage()); outputStream.close(); }
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

	public static void editItem(Integer ItemId, String ItemName, Double Price, String Description) {

		ItemDao dao = new ItemDao();
		double price = new BigDecimal(Price).setScale(2, RoundingMode.HALF_UP).doubleValue();
		Item item = new Item(ItemId, ItemName, price, Description);
		dao.changeItemInfo(item);

	}

	public static List<String> getItemComments(Integer ItemId) {

		ItemDao dao = new ItemDao();
		List<String> comments = new ArrayList<String>();
		;
		List<ItemRating> ratings = dao.getItemRating(ItemId);

		for (ItemRating r : ratings) {

			comments.add(r.getTextRating());
		}

		return comments;
	}

	public static List<ItemRating> getItemRatings(Integer ItemId) {

		ItemDao dao = new ItemDao();

		List<ItemRating> ratings = dao.getItemRating(ItemId);

		return ratings;
	}

	// Don't touch this method
	private static List<Integer> getItemAverageRatingForCalculation(Integer ItemId) {

		ItemDao dao = new ItemDao();
		List<Integer> avg = new ArrayList<Integer>();
		List<ItemRating> ratings = dao.getItemRating(ItemId);

		for (ItemRating r : ratings) {

			avg.add(r.getNumRating());
		}

		return avg;
	}

	// Don't touch this method
	private static Double calculateAvg(Integer ItemId) {
		Double sum = 0.0;
		List<Integer> average = getItemAverageRatingForCalculation(ItemId);

		for (Integer avg : average) {

			sum += avg;
		}

		return sum / average.size();

	}

	public static void updateItemAvg(Integer ItemId) {

		ItemDao dao = new ItemDao();
		double avg = new BigDecimal(calculateAvg(ItemId)).setScale(3, RoundingMode.HALF_UP).doubleValue();
		System.out.println(avg);
		dao.updateItemAvg(ItemId, avg);

	}

	public static List<Item> getItemBySeller(Integer SellerId) {

		ItemDao dao = new ItemDao();
		List<Item> items = dao.getItemByUser(SellerId);

		return items;
	}

	public static Double getItemAverageRating(Integer itemId) {

		ItemDao dao = new ItemDao();
		return dao.getItemById(itemId).getRatingAvg();
	}
	
	public static List<Item> getItemBySearch(String search) {

		ItemDao dao = new ItemDao();
		List<Item> items = dao.getItemBySearch(search);

		return items;
	}

	// need a list of all items
	// need a list of items by user

}
