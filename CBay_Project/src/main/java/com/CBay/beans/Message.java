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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import oracle.sql.TIMESTAMP;

@Entity
@Table(name="MESSAGE")
public class Message {
	
	@Id
	@Column(name="MessageID")
	@SequenceGenerator(sequenceName="MESSAGE_ID_SEQ", name="MESSAGE_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="MESSAGE_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ThreadID")
	private Integer ThreadID;
	
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="TransactionID")
	private Integer Transaction;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="SenderID")
	private Integer Sender;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ResponderID")
	private Integer Responder;
	
	@Column(name="MessageContent")
	private String MessageContent;
	
	@Column(name="Subject")
	private String Subject;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MessageTimeStamp")
	private Calendar MessageTimeStamp;

	public Message(Integer id, Integer threadID, Integer transaction, Integer sender, Integer responder,
			String messageContent, String subject, Calendar messageTimeStamp) {
		super();
		this.id = id;
		ThreadID = threadID;
		Transaction = transaction;
		Sender = sender;
		Responder = responder;
		MessageContent = messageContent;
		Subject = subject;
		MessageTimeStamp = messageTimeStamp;
	}

	public Message(Integer threadID, Integer transaction, Integer sender, Integer responder, String messageContent,
			String subject) {
		super();
		ThreadID = threadID;
		Transaction = transaction;
		Sender = sender;
		Responder = responder;
		MessageContent = messageContent;
		Subject = subject;
	}

	public Message() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getThreadID() {
		return ThreadID;
	}

	public void setThreadID(Integer threadID) {
		ThreadID = threadID;
	}

	public Integer getTransaction() {
		return Transaction;
	}

	public void setTransaction(Integer transaction) {
		Transaction = transaction;
	}

	public Integer getSender() {
		return Sender;
	}

	public void setSender(Integer sender) {
		Sender = sender;
	}

	public Integer getResponder() {
		return Responder;
	}

	public void setResponder(Integer responder) {
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

	public Calendar getMessageTimeStamp() {
		return MessageTimeStamp;
	}

	public void setMessageTimeStamp(Calendar messageTimeStamp) {
		MessageTimeStamp = messageTimeStamp;
	}

	

}