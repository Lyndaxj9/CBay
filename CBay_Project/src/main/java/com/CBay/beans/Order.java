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


@Entity
@Table(name="ORDERS")
public class Order {

	
	@Id
	@Column(name="TransactionID")
	@SequenceGenerator(sequenceName="TRANS_ID_SEQ", name="TRANS_ID_SEQ")
	@GeneratedValue(generator="TRANS_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer ID;
	
	@SequenceGenerator(sequenceName="ORDER_ID_SEQ", name="ORDER_ID_SEQ")
	@GeneratedValue(generator="ORDER_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer OrderID;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ItemID")
	private Item item;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="UserID")
	private User user;
	
	@Column
	private String Status;
	
	@Column
	private Integer Quantity;

	public Order(Integer iD, Integer orderID, Item item, User user, String status, Integer quantity) {
		super();
		ID = iD;
		OrderID = orderID;
		this.item = item;
		this.user = user;
		Status = status;
		Quantity = quantity;
	}

	public Order(Integer orderID, Item item, User user, String status, Integer quantity) {
		super();
		OrderID = orderID;
		this.item = item;
		this.user = user;
		Status = status;
		Quantity = quantity;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getOrderID() {
		return OrderID;
	}

	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	
	
	
}
