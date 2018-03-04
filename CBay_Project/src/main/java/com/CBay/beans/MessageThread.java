package com.CBay.beans;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name="THREADS")
public class MessageThread {

	
	@Id
	@Column(name="ThreadID")
	@SequenceGenerator(sequenceName="THREAD_ID_SEQ", name="THREAD_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="THREAD_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="SenderID")
	private Integer SenderId;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ResponderID")
	private Integer ResponderId;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ThreadTimeStamp")
	private Calendar ThreadTimeStamp;

	public MessageThread(Integer id, Integer sender, Integer responder, Calendar threadTimeStamp) {
		super();
		this.id = id;
		SenderId = sender;
		ResponderId = responder;
		ThreadTimeStamp = threadTimeStamp;
	}

	public MessageThread(Integer sender, Integer responder) {
		super();
		SenderId = sender;
		ResponderId = responder;
	}

	public MessageThread() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSender() {
		return SenderId;
	}

	public void setSender(Integer sender) {
		SenderId = sender;
	}

	public Integer getResponder() {
		return ResponderId;
	}

	public void setResponder(Integer responder) {
		ResponderId = responder;
	}

	public Calendar getThreadTimeStamp() {
		return ThreadTimeStamp;
	}

	public void setThreadTimeStamp(Calendar threadTimeStamp) {
		ThreadTimeStamp = threadTimeStamp;
	}
	
	
	
}
