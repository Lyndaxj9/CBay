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
@Table(name="ITEMRATING")
public class ItemRating {

	@Id
	@Column(name="RatingID")
	@SequenceGenerator(sequenceName="ITEM_RATING_ID_SEQ", name="ITEM_RATING_ID_SEQ")
	@GeneratedValue(generator="ITEM_RATING_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ItemID")
	private Item item;
	
	@Column(name="NumRating")
	private Integer NumRating;
	
	@Column(name="TextRating")
	private String TextRating;

	public ItemRating(Integer id, Item item, Integer numRating, String textRating) {
		super();
		this.id = id;
		this.item = item;
		NumRating = numRating;
		TextRating = textRating;
	}

	public ItemRating(Item item, Integer numRating, String textRating) {
		super();
		this.item = item;
		NumRating = numRating;
		TextRating = textRating;
	}

	public ItemRating() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
