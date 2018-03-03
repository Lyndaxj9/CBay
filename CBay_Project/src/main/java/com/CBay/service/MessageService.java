package com.CBay.service;

import com.CBay.beans.MessageThread;
import com.CBay.beans.User;
import com.CBay.dao.MessageDao;
import com.CBay.dao.UserDao;

public class MessageService {

	public static void createMessageThread(Integer SenderID, Integer ResponderID) {
	
		MessageDao dao = new MessageDao();
		MessageThread thread = new MessageThread(SenderID, ResponderID);
		dao.insertMessageThread(thread);
	}
}
