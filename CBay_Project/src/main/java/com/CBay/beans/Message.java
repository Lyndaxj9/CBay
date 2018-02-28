package com.CBay.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column
	private Integer TransactionID;
	
	@Column
	private Integer User1_ID;
	
	@Column
	private Integer User2_ID;
	
	@Column
	private String Message;
	
	@Column
	private String Subject;

	public Message(Integer iD, Integer threadID, Integer transactionID, Integer user1_ID, Integer user2_ID,
			String message, String subject) {
		super();
		ID = iD;
		ThreadID = threadID;
		TransactionID = transactionID;
		User1_ID = user1_ID;
		User2_ID = user2_ID;
		Message = message;
		Subject = subject;
	}
	

	public Message(Integer threadID, Integer transactionID, Integer user1_ID, Integer user2_ID, String message,
			String subject) {
		super();
		ThreadID = threadID;
		TransactionID = transactionID;
		User1_ID = user1_ID;
		User2_ID = user2_ID;
		Message = message;
		Subject = subject;
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

	public Integer getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(Integer transactionID) {
		TransactionID = transactionID;
	}

	public Integer getUser1_ID() {
		return User1_ID;
	}

	public void setUser1_ID(Integer user1_ID) {
		User1_ID = user1_ID;
	}

	public Integer getUser2_ID() {
		return User2_ID;
	}

	public void setUser2_ID(Integer user2_ID) {
		User2_ID = user2_ID;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}
	

}
