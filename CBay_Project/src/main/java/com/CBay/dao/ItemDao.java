package com.CBay.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.beans.Image;
import com.CBay.beans.Item;
import com.CBay.beans.ItemRating;
import com.CBay.beans.User;
import com.CBay.util.HibernateUtil;

public class ItemDao {

	public void insertItem(Item item) {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(item);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public Integer insertImage(String filePath, Integer itemId) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			String[] tokens = filePath.split("/");
			String FileName = (tokens[tokens.length - 1]);
			// FileName = FileName.substring(0, FileName.length()-4);

			Image img = new Image(itemId, FileName);
			// File file = new File(filePath);
			// FileInputStream inputStream = new FileInputStream(file);

			// Blob blob = Hibernate.getLobCreator(session).createBlob(inputStream,
			// file.length());
			byte[] photoBytes = readBytesFromFile(filePath);
			img.setImage(photoBytes);

			// img.setImage(blob);
			session.save(img);
			// blob.free();
			tx.commit();

			return img.getId();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	private byte[] readBytesFromFile(String filePath) throws IOException {

		File inputFile = new File(filePath);
		FileInputStream inputStream = new FileInputStream(inputFile);

		byte[] fileBytes = new byte[(int) inputFile.length()];
		inputStream.read(fileBytes);
		inputStream.close();

		return fileBytes;

	}

	public List<Image> getItemImages(Integer itemId) {
		List<Image> image = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String hql = "FROM Image WHERE ItemId= :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", itemId);
			image = query.list();
			return image;

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public void addItemRatingAndComment(ItemRating rating) {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(rating);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void changeItemInfo(Item ItemEdit) {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Item item = null;
		try {
			tx = session.beginTransaction();
			item = (Item) session.get(Item.class, ItemEdit.getId());
			item.setItemName(ItemEdit.getItemName());
			item.setPrice(ItemEdit.getPrice());
			item.setDescription(ItemEdit.getDescription());
			session.update(item);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<ItemRating> getItemRating(Integer ItemId) {

		List<ItemRating> rating = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String hql = "FROM ItemRating WHERE ItemId= :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", ItemId);
			rating = query.list();
			return rating;

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	public Item getItemById(Integer itemId) {
		Item item = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			item = (Item) session.get(Item.class, itemId);

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return item;

	}

	public void updateItemAvg(Integer ItemId, Double avg) {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Item item = null;
		try {
			tx = session.beginTransaction();
			item = (Item) session.get(Item.class, ItemId);
			item.setRatingAvg(avg);
			session.update(item);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public List<Item> getAllItems() {
		List<Item> items = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			items = session.createQuery("FROM Item").list();
			return items;

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Item> getItemByUser(Integer UserId) {

		List<Item> item = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String hql = "FROM Item WHERE UserId= :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", UserId);
			item = query.list();
			return item;

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}
	
	public List<Item> getItemBySearch(String search) {

		List<Item> item = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String hql = "FROM Item WHERE ItemName LIKE :Search";
			Query query = session.createQuery(hql);
			query.setParameter("Search", "%"+search+"%");
			item = query.list();
			return item;

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}


}
