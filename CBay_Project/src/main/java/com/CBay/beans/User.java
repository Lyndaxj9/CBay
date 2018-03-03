package com.CBay.beans;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class User {

	@Id
	@Column(name="UserID")
	@SequenceGenerator(sequenceName="USER_ID_SEQ", name="USER_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="USER_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="UserType")
	private String UserType;
	
	@Column(name="UserName")
	private String UserName;
	
	@Column(name="PW")
	private String PW;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="RatingAvg")
	private Integer RatingAvg;
	
	@Column(name="Description")
	private String Description;

	
	public User(Integer id, String firstName, String lastName, String type, String userName, String password,
			String email, Integer rating, String description) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		UserType = type;
		UserName = userName;
		PW = password;
		Email = email;
		RatingAvg = rating;
		Description = description;
	}
	
	

	public User(String firstName, String lastName, String type, String userName, String password, String email,
			Integer rating, String description) {
		super();
		FirstName = firstName;
		LastName = lastName;
		UserType = type;
		UserName = userName;
		PW = password;
		Email = email;
		RatingAvg = rating;
		Description = description;
	}



	public User(String firstName, String lastName, String type, String userName, String password, String email) {
		super();
		FirstName = firstName;
		LastName = lastName;
		UserType = type;
		UserName = userName;
		PW = password;
		Email = email;
	
	}

	public User() {
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}



	public String getUserType() {
		return UserType;
	}



	public void setUserType(String userType) {
		UserType = userType;
	}



	public String getPW() {
		return PW;
	}



	public void setPW(String pW) {
		PW = pW;
	}



	public Integer getRatingAvg() {
		return RatingAvg;
	}



	public void setRatingAvg(Integer ratingAvg) {
		RatingAvg = ratingAvg;
	}

	
	
	
}
