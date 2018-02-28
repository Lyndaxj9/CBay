package com.CBay.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RATING")
public class Rating {

	@Id
	@Column(name="RatingID")
	@SequenceGenerator(sequenceName="RATING_ID_SEQ", name="RATING_ID_SEQ")
	@GeneratedValue(generator="RATING_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer ID;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="UserID")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ItemID")
	private Item item;
	
	@Column
	private Integer NumRatingItem;
	
	@Column
	private String TextRatingItem;
	
	@Column
	private Integer NumRatingSeller;
	
	@Column
	private String TextRatingSeller;

	public Rating(Integer iD, User user, Item item, Integer numRatingItem, String textRatingItem,
			Integer numRatingSeller, String textRatingSeller) {
		super();
		ID = iD;
		this.user = user;
		this.item = item;
		NumRatingItem = numRatingItem;
		TextRatingItem = textRatingItem;
		NumRatingSeller = numRatingSeller;
		TextRatingSeller = textRatingSeller;
	}

	public Rating(User user, Item item, Integer numRatingItem, String textRatingItem, Integer numRatingSeller,
			String textRatingSeller) {
		super();
		this.user = user;
		this.item = item;
		NumRatingItem = numRatingItem;
		TextRatingItem = textRatingItem;
		NumRatingSeller = numRatingSeller;
		TextRatingSeller = textRatingSeller;
	}

	public Rating() {
		// TODO Auto-generated constructor stub
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getNumRatingItem() {
		return NumRatingItem;
	}

	public void setNumRatingItem(Integer numRatingItem) {
		NumRatingItem = numRatingItem;
	}

	public String getTextRatingItem() {
		return TextRatingItem;
	}

	public void setTextRatingItem(String textRatingItem) {
		TextRatingItem = textRatingItem;
	}

	public Integer getNumRatingSeller() {
		return NumRatingSeller;
	}

	public void setNumRatingSeller(Integer numRatingSeller) {
		NumRatingSeller = numRatingSeller;
	}

	public String getTextRatingSeller() {
		return TextRatingSeller;
	}

	public void setTextRatingSeller(String textRatingSeller) {
		TextRatingSeller = textRatingSeller;
	}

	
	
}
