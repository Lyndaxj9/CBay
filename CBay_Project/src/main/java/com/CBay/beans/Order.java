package com.CBay.beans;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import oracle.sql.TIMESTAMP;


@Entity
@Table(name="ORDERS")
public class Order {

	
	@Id
	@Column(name="OrderID")
	@SequenceGenerator(sequenceName="ORDER_ID_SEQ", name="ORDER_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="ORDER_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="BuyerID")
	private Integer buyerId;
	
	@Column(name="Status")
	private String Status;
	
	@Column(name="TotalItems")
	private Integer TotalItems;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OrderTimeStamp")
	private Calendar OrderTimeStamp;

	public Order(Integer id, Integer buyer, Integer totalItems, String status, Calendar orderTimeStamp) {
		super();
		this.id = id;
		buyerId = buyer;
		Status = status;
		TotalItems = totalItems;
		OrderTimeStamp = orderTimeStamp;
	}
	
	

	public Order(Integer buyer, Integer totalItems, String status) {
		super();
		buyerId = buyer;
		Status = status;
		TotalItems = totalItems;
	}


	public Order() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBuyerId() {
		
		return buyerId;
	}

	public void setBuyer(Integer buyer) {
		this.buyerId = buyer;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Integer getTotalItems() {
		return TotalItems;
	}

	public void setTotalItems(Integer totalItems) {
		TotalItems = totalItems;
	}



	public Calendar getOrderTimeStamp() {
		return OrderTimeStamp;
	}



	public void setOrderTimeStamp(Calendar orderTimeStamp) {
		OrderTimeStamp = orderTimeStamp;
	}

	
	
}
