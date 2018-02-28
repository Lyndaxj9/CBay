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

	
	
	
}
