package com.example.mockdemo.messenger;

public class MockMessageService implements MessageService {
	
	private boolean connected = false;
	private boolean sent = false;
	
	public void setConnection(boolean status) {
		connected = status;
	}
	
	public void setMessageIsSent(boolean status) {
		sent = status;
	}
	
	public boolean getConnected() {
		return connected;
}
	public boolean getSent() {
		return sent;
}
	
	@Override
	public ConnectionStatus checkConnection(String server) {
		if (server.matches("[a-z].*.pl$") && connected)
			return ConnectionStatus.SUCCESS;
		return ConnectionStatus.FAILURE;
	}
	
	@Override
	public SendingStatus send(String server, String message) throws MalformedRecipientException {
		if(server == null || server.length() < 4)
			throw new MalformedRecipientException();
		if (message == null || message.length() < 3)
			throw new MalformedRecipientException();
		if (sent)
			return SendingStatus.SENT;
		return SendingStatus.SENDING_ERROR;
	}
}
