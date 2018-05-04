package com.example.mockdemo.app;

import org.easymock.EasyMock;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;

public class MessageAppEasyMockTest {
	
	private MessageService mockMessageService;
	private Messenger messenger;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockMessageService = EasyMock.createMock(MessageService.class);
		messenger = new Messenger(mockMessageService);
	}
	
	@Test
	public void ValidConnection() {
		EasyMock.expect(mockMessageService.checkConnection("onet.pl")).andReturn(ConnectionStatus.SUCCESS);
		EasyMock.replay(mockMessageService);
		int response = messenger.testConnection("onet.pl");
		assertEquals(0, response);
		EasyMock.verify(mockMessageService);
	}
		
	@Test
	public void NullServerAndNullMessage() throws MalformedRecipientException {
		EasyMock.expect(mockMessageService.send(null, null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockMessageService);
		int response = messenger.sendMessage(null, null);
		assertEquals(2, response);
		EasyMock.verify(mockMessageService);
}
	
	@Test
	public void ValidServerAndNullMessage() throws MalformedRecipientException {
		EasyMock.expect(mockMessageService.send("onet.pl", null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockMessageService);
		int response = messenger.sendMessage("onet.pl", null);
		assertEquals(2, response);
		EasyMock.verify(mockMessageService);
}
	
	@Test
	public void InvalidServerAndNullMessage() throws MalformedRecipientException {
		EasyMock.expect(mockMessageService.send(".eu", null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockMessageService);
		int response = messenger.sendMessage(".eu", null);
		assertEquals(2, response);
		EasyMock.verify(mockMessageService);
}
		
	@Test
	public void InvalidServerAndValidMessage() throws MalformedRecipientException {
		EasyMock.expect(mockMessageService.send(".eu", null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockMessageService);
		int response = messenger.sendMessage(".eu", null);
		assertEquals(2, response);
		EasyMock.verify(mockMessageService);
}
	
	@Test
	public void NullServerAndValidMessage() throws MalformedRecipientException {
		EasyMock.expect(mockMessageService.send(null, "content")).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockMessageService);
		int response = messenger.sendMessage(null, "content");
		assertEquals(2, response);
		EasyMock.verify(mockMessageService);
}
	
	@AfterEach
	public void tearDown() throws Exception {
		mockMessageService = null;
		messenger = null;
}

}
