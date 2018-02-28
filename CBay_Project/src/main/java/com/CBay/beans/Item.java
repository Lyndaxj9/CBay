package com.CBay.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ITEM")
public class Item {

	
	@Id
	@Column(name="ItemID")
	@SequenceGenerator(sequenceName="ITEM_ID_SEQ", name="ITEM_ID_SEQ")
	@GeneratedValue(generator="ITEM_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer ID;
	
	@Column
	private Integer SellerID;
	
	@Column
	private String Name;
	
	@Column
	private String Description;
	
	@Column
	private Blob Image;
	
	@Column
	private String Email;
	
	@Column
	private Integer RatingAvg;

	public Item(Integer iD, Integer sellerID, String name, String description, Blob image, String email,
			Integer ratingAvg) {
		super();
		ID = iD;
		SellerID = sellerID;
		Name = name;
		Description = description;
		Image = image;
		Email = email;
		RatingAvg = ratingAvg;
	}
	

	public Item(Integer sellerID, String name, String description, Blob image, String email, Integer ratingAvg) {
		super();
		SellerID = sellerID;
		Name = name;
		Description = description;
		Image = image;
		Email = email;
		RatingAvg = ratingAvg;
	}



	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getSellerID() {
		return SellerID;
	}

	public void setSellerID(Integer sellerID) {
		SellerID = sellerID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Blob getPicture() {
		return Image;
	}

	public void setPicture(Blob image) {
		Image = image;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Integer getRatingAvg() {
		return RatingAvg;
	}

	public void setRatingAvg(Integer ratingAvg) {
		RatingAvg = ratingAvg;
	}
	
	
	
	
}
