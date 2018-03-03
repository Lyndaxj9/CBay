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
@Table(name="TRANSACTIONS")
public class Transactions {
	
	@Id
	@Column(name="TransactionID")
	@SequenceGenerator(sequenceName="TRANS_ID_SEQ", name="TRANS_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="TRANS_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="OrderID")
	private Order order;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ItemID")
	private Item item;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="BuyerID")
	private User buyer;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="SellerID")
	private User seller;
	
	@Column(name="Status")
	private String Status;
	
	@Column(name="Quantity")
	private Integer Quantity;

	public Transactions(Integer id, Order order, Item item, User buyer, User seller, String status, Integer quantity) {
		super();
		this.id = id;
		this.order = order;
		this.item = item;
		this.buyer = buyer;
		this.seller = seller;
		Status = status;
		Quantity = quantity;
	}

	public Transactions(Order order, Item item, User buyer, User seller, String status, Integer quantity) {
		super();
		this.order = order;
		this.item = item;
		this.buyer = buyer;
		this.seller = seller;
		Status = status;
		Quantity = quantity;
	}

	public Transactions() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
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

