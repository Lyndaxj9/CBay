package com.CBay.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column
	private Integer BuyerID;
	
	@Column
	private Integer ItemID;
	
	@Column
	private Integer NumRating;
	
	@Column
	private String TextRating;

	public Rating(Integer iD, Integer buyerID, Integer itemID, Integer numRating, String textRating) {
		super();
		ID = iD;
		BuyerID = buyerID;
		ItemID = itemID;
		NumRating = numRating;
		TextRating = textRating;
	}

	public Rating(Integer buyerID, Integer itemID, Integer numRating, String textRating) {
		super();
		BuyerID = buyerID;
		ItemID = itemID;
		NumRating = numRating;
		TextRating = textRating;
	}



	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getBuyerID() {
		return BuyerID;
	}

	public void setBuyerID(Integer buyerID) {
		BuyerID = buyerID;
	}

	public Integer getItemID() {
		return ItemID;
	}

	public void setItemID(Integer itemID) {
		ItemID = itemID;
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
