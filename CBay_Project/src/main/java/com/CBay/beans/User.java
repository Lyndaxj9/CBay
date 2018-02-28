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
@Table(name="USER")
public class User {

	@Id
	@Column(name="UserID")
	@SequenceGenerator(sequenceName="USER_ID_SEQ", name="USER_ID_SEQ")
	@GeneratedValue(generator="USER_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer ID;
	
	@Column
	private String FirstName;
	
	@Column
	private String LastName;
	
	@Column
	private String type;
	
	@Column(unique = true)
	private String UserName;
	@Column
	private String Password;
	
	@Column(unique = true)
	private String Email;
	
	@OneToMany(mappedBy="NumRating", fetch=FetchType.EAGER)
	private Set<Rating> rating;
	
	@Column
	private String Description;

	public User(Integer iD, String firstName, String lastName, String type, String userName, String password,
			String email, Set<Rating> rating, String description) {
		super();
		ID = iD;
		FirstName = firstName;
		LastName = lastName;
		this.type = type;
		UserName = userName;
		Password = password;
		Email = email;
		this.rating = rating;
		Description = description;
	}

	public User(String firstName, String lastName, String type, String userName, String password, String email,
			Set<Rating> rating, String description) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.type = type;
		UserName = userName;
		Password = password;
		Email = email;
		this.rating = rating;
		Description = description;
	}

	public User(Integer iD, String firstName, String lastName, String type, String userName, String password,
			String email) {
		super();
		ID = iD;
		FirstName = firstName;
		LastName = lastName;
		this.type = type;
		UserName = userName;
		Password = password;
		Email = email;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Set<Rating> getRating() {
		return rating;
	}

	public void setRating(Set<Rating> rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
