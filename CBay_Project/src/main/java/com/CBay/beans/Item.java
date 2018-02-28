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
	private String Name;
	
	@Column
	private String Description;
	 
	@Column
	private Integer Price;
	
	@OneToMany(mappedBy="ImageID", fetch=FetchType.EAGER)
	private Set<Image> image;
	
	
	@OneToMany(mappedBy="NumRating", fetch=FetchType.EAGER)
	private Set<Rating> RatingAvg;
	
	@OneToMany(mappedBy="TextRating", fetch=FetchType.EAGER)
	private Set<Rating> RatingText;

	
	public Item(Integer iD, User user, String name, String description, Set<Image> image, Integer price,
			Set<Rating> ratingAvg, Set<Rating> ratingText) {
		super();
		ID = iD;
		this.user = user;
		Name = name;
		Description = description;
		this.image = image;
		Price = price;
		RatingAvg = ratingAvg;
		RatingText = ratingText;
	}

	public Item(User user, String name, String description, Set<Image> image, Integer price, Set<Rating> ratingAvg,
			Set<Rating> ratingText) {
		super();
		this.user = user;
		Name = name;
		Description = description;
		this.image = image;
		Price = price;
		RatingAvg = ratingAvg;
		RatingText = ratingText;
	}

	public Item(User user, String name, String description, Set<Image> image, Integer price) {
		super();
		this.user = user;
		Name = name;
		Description = description;
		this.image = image;
		Price = price;
	}
	
	

	public Item(String name, String description, Integer price) {
		super();
		Name = name;
		Description = description;
		Price = price;
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

	public Set<Image> getImage() {
		return image;
	}

	public void setImage(Set<Image> image) {
		this.image = image;
	}

	
	public Set<Rating> getRatingAvg() {
		return RatingAvg;
	}

	public void setRatingAvg(Set<Rating> ratingAvg) {
		RatingAvg = ratingAvg;
	}

	public Set<Rating> getRatingText() {
		return RatingText;
	}

	public void setRatingText(Set<Rating> ratingText) {
		RatingText = ratingText;
	}

	
	
	
	
	
	
}
