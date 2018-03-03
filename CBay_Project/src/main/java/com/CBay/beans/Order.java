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
	
	//@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ItemID")
	private Integer ItemId;
	
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

	public Order(Integer id, Integer item, Integer buyer, String status, Integer totalItems, Calendar orderTimeStamp) {
		super();
		this.id = id;
		this.ItemId = item;
		buyerId = buyer;
		Status = status;
		TotalItems = totalItems;
		OrderTimeStamp = orderTimeStamp;
	}
	
	

	public Order(Integer item, Integer buyer, String status, Integer totalItems) {
		super();
		this.ItemId = item;
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

	public Integer getItem() {
		return ItemId;
	}

	public void setItem(Integer item) {
		this.ItemId = item;
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
