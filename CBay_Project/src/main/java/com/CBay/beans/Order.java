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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import oracle.sql.TIMESTAMP;


@Entity
@Table(name="ORDERS")
public class Order {

	
	@Id
	@Column(name="OrderID")
	@SequenceGenerator(sequenceName="ORDER_ID_SEQ", name="ORDER_ID_SEQ")
	@GeneratedValue(generator="ORDER_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ItemID")
	private Item item;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="BuyerID")
	private User buyer;
	
	@Column(name="Status")
	private String Status;
	
	@Column(name="TotalItems")
	private Integer TotalItems;
	
	@Column(name="OrderTimeStamp")
	private TIMESTAMP OrderTimeStamp;

	public Order(Integer id, Item item, User buyer, String status, Integer totalItems, TIMESTAMP orderTimeStamp) {
		super();
		this.id = id;
		this.item = item;
		this.buyer = buyer;
		Status = status;
		TotalItems = totalItems;
		OrderTimeStamp = orderTimeStamp;
	}
	
	

	public Order(Item item, User buyer, String status, Integer totalItems) {
		super();
		this.item = item;
		this.buyer = buyer;
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
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



	public TIMESTAMP getOrderTimeStamp() {
		return OrderTimeStamp;
	}



	public void setOrderTimeStamp(TIMESTAMP orderTimeStamp) {
		OrderTimeStamp = orderTimeStamp;
	}

	
	
}
