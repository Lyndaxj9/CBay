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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGE")
public class Message {
	
	@Id
	@Column(name="MessageID")
	@SequenceGenerator(sequenceName="MESSAGE_ID_SEQ", name="MESSAGE_ID_SEQ")
	@GeneratedValue(generator="MESSAGE_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer ID;
	
	
	@Column
	private Integer ThreadID;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="TransactionID")
	private Order order;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="SenderID")
	private User Sender;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ResponderID")
	private User Responder;
	
	@Column
	private String MessageContent;
	
	@Column
	private String Subject;

	public Message(Integer iD, Integer threadID, Order order, User sender, User responder, String message, String subject) {
		super();
		ID = iD;
		ThreadID = threadID;
		this.order = order;
		Sender = sender;
		Responder = responder;
		MessageContent = message;
		Subject = subject;
	}

	public Message(Integer threadID, Order order, User sender, User responder, String message, String subject) {
		super();
		ThreadID = threadID;
		this.order = order;
		Sender = sender;
		Responder = responder;
		MessageContent = message;
		Subject = subject;
	}

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getThreadID() {
		return ThreadID;
	}

	public void setThreadID(Integer threadID) {
		ThreadID = threadID;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getSender() {
		return Sender;
	}

	public void setSender(User sender) {
		Sender = sender;
	}

	public User getResponder() {
		return Responder;
	}

	public void setResponder(User responder) {
		Responder = responder;
	}

	public String getMessageContent() {
		return MessageContent;
	}

	public void setMessageContent(String messageContent) {
		MessageContent = messageContent;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	
	

}
