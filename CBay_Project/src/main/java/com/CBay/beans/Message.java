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

import oracle.sql.TIMESTAMP;

@Entity
@Table(name="MESSAGE")
public class Message {
	
	@Id
	@Column(name="MessageID")
	@SequenceGenerator(sequenceName="MESSAGE_ID_SEQ", name="MESSAGE_ID_SEQ")
	@GeneratedValue(generator="MESSAGE_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ThreadID")
	private MessageThread ThreadID;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="TransactionID")
	private Order order;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="SenderID")
	private User Sender;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ResponderID")
	private User Responder;
	
	@Column(name="MessageContent")
	private String MessageContent;
	
	@Column(name="Subject")
	private String Subject;

	@Column(name="MessageTimeStamp")
	private TIMESTAMP MessageTimeStamp;

	public Message(Integer id, MessageThread threadID, Order order, User sender, User responder, String messageContent,
			String subject, TIMESTAMP messageTimeStamp) {
		super();
		this.id = id;
		ThreadID = threadID;
		this.order = order;
		Sender = sender;
		Responder = responder;
		MessageContent = messageContent;
		Subject = subject;
		MessageTimeStamp = messageTimeStamp;
	}

	public Message(MessageThread threadID, Order order, User sender, User responder, String messageContent,
			String subject) {
		super();
		ThreadID = threadID;
		this.order = order;
		Sender = sender;
		Responder = responder;
		MessageContent = messageContent;
		Subject = subject;
	}

	public Message() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MessageThread getThreadID() {
		return ThreadID;
	}

	public void setThreadID(MessageThread threadID) {
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

	public TIMESTAMP getMessageTimeStamp() {
		return MessageTimeStamp;
	}

	public void setMessageTimeStamp(TIMESTAMP messageTimeStamp) {
		MessageTimeStamp = messageTimeStamp;
	}
	
	
	

}