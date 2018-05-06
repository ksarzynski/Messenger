package com.projekt2.app;

import com.projekt2.messenger.ConnectionStatus;
import com.projekt2.messenger.MalformedRecipientException;
import com.projekt2.messenger.MessageService;
import com.projekt2.messenger.SendingStatus;


public class Messenger {

	private MessageService ms;

	public Messenger(MessageService ms) {
		this.ms = ms;
	}

	public int testConnection(String server) {
		if (ms.checkConnection(server) == ConnectionStatus.SUCCESS) 
			return 0; 
		else 
			return 1;
		}

	public int sendMessage(String server, String message) {

		int result = -1;
		
		try {
            SendingStatus sendstatus = ms.send(server, message);
			switch(sendstatus){
			case SENT:
				result = 0;
				break;
			case SENDING_ERROR:
				result = 1;
				break;
				}
			}
		catch(MalformedRecipientException exception) {
			 result = 2; 
			 }
		return result;
	}
}
