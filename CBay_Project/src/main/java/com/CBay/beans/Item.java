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
	@SequenceGenerator(sequenceName="ITEM_ID_SEQ", name="ITEM_ID_SEQ")
	@GeneratedValue(generator="ITEM_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer ID;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="UserID")
	private User user;
	
	@Column
	private String ItemName;
	
	@Column
	private String Description;
	 
	@Column
	private Integer Price;
	
	// map this to the Image Table instead
	/*@OneToMany(mappedBy="ImageID", fetch=FetchType.EAGER)
	private Set<Image> Image;*/
	
	
	@Column
	private Integer RatingAvg;
	
	// map this to the Rating Table instead
	/*@OneToMany(mappedBy="TextRating", fetch=FetchType.EAGER)
	private Set<Rating> RatingText;*/

	
	public Item(Integer iD, User user, String name, String description, Set<Image> image, Integer price,
			Integer ratingAvg) {
		super();
		ID = iD;
		this.user = user;
		ItemName = name;
		Description = description;
		//this.image = image;
		Price = price;
		RatingAvg = ratingAvg;
	}

	public Item(User user, String name, String description, Set<Image> image, Integer price, Integer ratingAvg) {
		super();
		this.user = user;
		ItemName = name;
		Description = description;
		//this.image = image;
		Price = price;
		RatingAvg = ratingAvg;
	}

	public Item(User user, String name, String description, Set<Image> image, Integer price) {
		super();
		this.user = user;
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

	public Item() {
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

	

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	/*public Set<Image> getImage() {
		return image;
	}

	public void setImage(Set<Image> image) {
		this.image = image;
	}*/


	public Integer getRatingAvg() {
		return RatingAvg;
	}

	public void setRatingAvg(Integer ratingAvg) {
		RatingAvg = ratingAvg;
	}

	/*public Set<Rating> getRatingText() {
		return RatingText;
	}

	public void setRatingText(Set<Rating> ratingText) {
		RatingText = ratingText;
	}*/

	
	
	
	
	
	
}
