package com.CBay.service;

import com.CBay.beans.Message;
import com.CBay.beans.MessageThread;
import com.CBay.dao.MessageDao;

public class MessageService {

	public static Integer createMessageThread(Integer SenderId, Integer ResponderId) {
	
		MessageDao dao = new MessageDao();
		MessageThread thread = new MessageThread(SenderId, ResponderId);
		dao.insertMessageThread(thread);
		return thread.getId();
	}
	
	public static Integer SendMessage(Integer ThreadId, Integer TransactionId, Integer SenderId, Integer ResponderId, String MessageContent, String Subject) {
		
		MessageDao dao = new MessageDao();
		Message msg = new Message(ThreadId, TransactionId, SenderId, ResponderId, MessageContent, Subject);
		dao.insertMessage(msg);
		return msg.getId();
	
	}
	
	
	
	
}
