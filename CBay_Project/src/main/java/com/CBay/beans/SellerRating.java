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
@Table(name="SELLERRATING")
public class SellerRating {

	@Id
	@Column(name="RatingID")
	@SequenceGenerator(sequenceName="SELLER_RATING_ID_SEQ", name="SELLER_RATING_ID_SEQ")
	@GeneratedValue(generator="SELLER_RATING_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="UserID")
	private User user;
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name="ItemID")
//	private Item item;
	
	@Column(name="NumRating")
	private Integer NumRating;
	
	@Column(name="TextRating")
	private String TextRating;

	public SellerRating(Integer id, User user, Integer numRating, String textRating) {
		super();
		this.id = id;
		this.user = user;
		NumRating = numRating;
		TextRating = textRating;
	}

	public SellerRating(User user, Integer numRating, String textRating) {
		super();
		this.user = user;
		NumRating = numRating;
		TextRating = textRating;
	}

	public SellerRating() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getNumRating() {
		return NumRating;
	}

	public void setNumRating(Integer numRating) {
		NumRating = numRating;
	}

	public String getTextRating() {
		return TextRating;
	}

	public void setTextRating(String textRating) {
		TextRating = textRating;
	}
	
	
	
	

	
	

	
	
}
