package com.CBay.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ORDER")
public class Order {

	
	@Id
	@Column(name="TransactionID")
	@SequenceGenerator(sequenceName="TRANS_ID_SEQ", name="TRANS_ID_SEQ")
	@GeneratedValue(generator="TRANS_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer ID;
	
	@Column
	private Integer OrderID;
	
	@Column
	private Integer ItemID;
	
	@Column
	private Integer BuyerID;
	
	@Column
	private String Status;
	
	@Column
	private Integer Quantity;

	public Order(Integer iD, Integer orderID, Integer itemID, Integer buyerID, String status, Integer quantity) {
		super();
		ID = iD;
		OrderID = orderID;
		ItemID = itemID;
		BuyerID = buyerID;
		Status = status;
		Quantity = quantity;
	}

	
	public Order(Integer orderID, Integer itemID, Integer buyerID, String status, Integer quantity) {
		super();
		OrderID = orderID;
		ItemID = itemID;
		BuyerID = buyerID;
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

	public Integer getItemID() {
		return ItemID;
	}

	public void setItemID(Integer itemID) {
		ItemID = itemID;
	}

	public Integer getBuyerID() {
		return BuyerID;
	}

	public void setBuyerID(Integer buyerID) {
		BuyerID = buyerID;
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
