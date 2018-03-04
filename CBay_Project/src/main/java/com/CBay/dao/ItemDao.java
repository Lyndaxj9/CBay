package com.CBay.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.beans.Image;
import com.CBay.beans.Item;
import com.CBay.beans.MessageThread;
import com.CBay.util.HibernateUtil;

public class ItemDao {

	public void insertItem(Item item){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(item);
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
			
	}

	public void insertImage(Image img) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(img);
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}

	public Integer insertImage(String filePath, Integer itemId) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String[] tokens = filePath.split("/");
			String FileName = (tokens[tokens.length-1]);
			//FileName = FileName.substring(0, FileName.length()-4);
			
			Image img = new Image(itemId, FileName);
			//File file = new File(filePath);
			//FileInputStream inputStream = new FileInputStream(file);
			
			//Blob blob = Hibernate.getLobCreator(session).createBlob(inputStream, file.length());
			byte[] photoBytes = readBytesFromFile(filePath);
			img.setImage(photoBytes);
			
			
			//img.setImage(blob);
			session.save(img);
			//blob.free();
			tx.commit();
			
			return img.getId();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
		
	}

	private byte[] readBytesFromFile(String filePath) throws IOException {
		
		File inputFile = new File(filePath);
		FileInputStream inputStream = new FileInputStream(inputFile);
		
		byte[] fileBytes = new byte[ (int) inputFile.length()];
		inputStream.read(fileBytes);
		inputStream.close();
		
		return fileBytes;
		
	}

	public List<Image> getItemImages(Integer itemId) {
		List<Image> image = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			String hql = "FROM Image WHERE ItemId= :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", itemId);
			image = query.list();
			return image;
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

	
}
