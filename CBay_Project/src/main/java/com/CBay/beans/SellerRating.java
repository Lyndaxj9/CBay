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
	@SequenceGenerator(sequenceName="SELLER_RATING_ID_SEQ", name="SELLER_RATING_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="SELLER_RATING_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="UserID")
	private Integer userId;
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name="ItemID")
//	private Item item;
	
	@Column(name="NumRating")
	private Integer NumRating;
	
	@Column(name="TextRating")
	private String TextRating;

	public SellerRating(Integer id, Integer user, Integer numRating, String textRating) {
		super();
		this.id = id;
		this.userId = user;
		NumRating = numRating;
		TextRating = textRating;
	}

	public SellerRating(Integer user, Integer numRating, String textRating) {
		super();
		this.userId = user;
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

	public Integer getUser() {
		return userId;
	}

	public void setUser(Integer user) {
		this.userId = user;
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
