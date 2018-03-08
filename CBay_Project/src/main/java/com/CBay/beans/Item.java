package com.CBay.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="ITEM")
public class Item {

	
	@Id
	@Column(name="ItemID")
	@SequenceGenerator(sequenceName="ITEM_ID_SEQ", name="ITEM_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="ITEM_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	//@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="UserID")
	private Integer UserId;
	
	@Column(name="ItemName")
	private String ItemName;
	
	@Column(name="Description")
	private String Description;
	 
	@Column(name="Price")
	private Integer Price;
	
	@Column(name="Quantity")
	private Integer Quantity;
	
	@Column(name="RatingAvg")
	private Double RatingAvg;
	
	
	

	
	public Item(Integer id, Integer user, String name, String description, Integer price, Integer quantity, Double ratingAvg) {
		super();
		this.id = id;
		this.UserId = user;
		ItemName = name;
		Description = description;
		Price = price;
		RatingAvg = ratingAvg;
		Quantity = quantity;
	}

	public Item(Integer user, String name, String description, Integer price, Integer quantity, Double ratingAvg) {
		super();
		this.UserId = user;
		ItemName = name;
		Description = description;
		Price = price;
		RatingAvg = ratingAvg;
		Quantity = quantity;
	}

	
	public Item(Integer user, String name, String description, Integer price) {
		super();
		this.UserId = user;
		ItemName = name;
		Description = description;
		//this.image = image;
		Price = price;
	}
	
	

	public Item(String name, String description, Integer price) {
		super();
		ItemName = name;
		Description = description;
		Price = price;
	}
	

	public Item(Integer id, String itemName, Integer price, String description) {
		super();
		this.id = id;
		ItemName = itemName;
		Description = description;
		Price = price;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public Double getRatingAvg() {
		return RatingAvg;
	}

	public void setRatingAvg(Double avg) {
		RatingAvg = avg;
	}

	
	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	
	
	
	
	
	
}
