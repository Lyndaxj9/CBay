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
	
	// @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="OrderID")
	private Integer OrderId;
	
	
	// @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ItemID")
	private Integer ItemId;
	
	// @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="BuyerID")
	private Integer BuyerId;
	
	// @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="SellerID")
	private Integer SellerId;
	
	@Column(name="Status")
	private String Status;
	
	@Column(name="Quantity")
	private Integer Quantity;

	public Transactions(Integer id, Integer orderId, Integer itemId, Integer buyerId, Integer sellerId, String status, Integer quantity) {
		super();
		this.id = id;
		OrderId = orderId;
		ItemId = itemId;
		BuyerId = buyerId;
		SellerId = sellerId;
		Status = status;
		Quantity = quantity;
	}

	public Transactions(Integer orderId, Integer itemId, Integer buyerId, Integer sellerId, String status, Integer quantity) {
		super();
		OrderId = orderId;
		ItemId = itemId;
		BuyerId = buyerId;
		SellerId = sellerId;
		Status = status;
		Quantity = quantity;
	}

	public Transactions(Integer itemId, Integer buyerId, Integer sellerId, String status, Integer quantity) {
		super();
		ItemId = itemId;
		BuyerId = buyerId;
		SellerId = sellerId;
		Status = status;
		Quantity = quantity;
	}

	public Transactions() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public Integer getItemId() {
		return ItemId;
	}

	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}

	public Integer getBuyerId() {
		return BuyerId;
	}

	public void setBuyerId(Integer buyerId) {
		BuyerId = buyerId;
	}

	public Integer getSellerId() {
		return SellerId;
	}

	public void setSellerId(Integer sellerId) {
		SellerId = sellerId;
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

