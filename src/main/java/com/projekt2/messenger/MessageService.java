package com.projekt2.messenger;

public interface MessageService {
		
	ConnectionStatus checkConnection(String server);
	
	SendingStatus send(String server, String message) throws MalformedRecipientException;

}
