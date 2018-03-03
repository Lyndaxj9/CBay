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
@Table(name="THREADS")
public class MessageThread {

	
	@Id
	@Column(name="ThreadID")
	@SequenceGenerator(sequenceName="THREAD_ID_SEQ", name="THREAD_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="THREAD_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="SenderID")
	private User Sender;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ResponderID")
	private User Responder;
	
	@Column(name="ThreadTimeStamp")
	private TIMESTAMP ThreadTimeStamp;

	public MessageThread(Integer id, User sender, User responder, TIMESTAMP threadTimeStamp) {
		super();
		this.id = id;
		Sender = sender;
		Responder = responder;
		ThreadTimeStamp = threadTimeStamp;
	}

	public MessageThread(User sender, User responder) {
		super();
		Sender = sender;
		Responder = responder;
	}

	public MessageThread() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public TIMESTAMP getThreadTimeStamp() {
		return ThreadTimeStamp;
	}

	public void setThreadTimeStamp(TIMESTAMP threadTimeStamp) {
		ThreadTimeStamp = threadTimeStamp;
	}
	
	
	
}
