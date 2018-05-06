package com.projekt2.app;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.projekt2.messenger.ConnectionStatus;
import com.projekt2.messenger.MalformedRecipientException;
import com.projekt2.messenger.MessageService;
import com.projekt2.messenger.SendingStatus;

public class MessageAppMockitoTest {
	
	@Mock
	MessageService mockMessageService;
	private Messenger messenger;

	@BeforeEach
	public void setUp() throws Exception {
		  MockitoAnnotations.initMocks(this);
		  messenger = new Messenger(mockMessageService);
	}
	
	@Test
	public void ValidServerSuccessConnection() {
		when(mockMessageService.checkConnection("pg.edu.pl")).thenReturn(ConnectionStatus.SUCCESS);
	    assertThat(messenger.testConnection("pg.edu.pl")).isZero();
		verify(mockMessageService).checkConnection("pg.edu.pl");
	}
	
	@Test
	public void InvalidServerFailureConnection() {
		when(mockMessageService.checkConnection("pg.edu.com")).thenReturn(ConnectionStatus.FAILURE);
		assertThat(messenger.testConnection("pg.edu.com")).isSameAs(1);
		verify(mockMessageService).checkConnection("pg.edu.com");
	}
	
	@Test
	public void ValidMessageSent() throws MalformedRecipientException {
		when(mockMessageService.send("pg.edu.pl", "content")).thenReturn(SendingStatus.SENT);
		assertThat(messenger.sendMessage("pg.edu.pl", "content")).isZero();
		verify(mockMessageService).send("pg.edu.pl", "content");
	}
	
	@Test
	public void ValidMessageSendingError() throws MalformedRecipientException {
		when(mockMessageService.send("pg.edu.pl", "content")).thenReturn(SendingStatus.SENDING_ERROR);
		assertThat(messenger.sendMessage("pg.edu.pl", "content")).isSameAs(1);
		verify(mockMessageService).send("pg.edu.pl", "content");
	}
	
	@Test
	public void InvalidMessageContentThrowException() throws MalformedRecipientException {
		when(mockMessageService.send("pg.edu.pl", "m")).thenThrow(new MalformedRecipientException());
		assertThat(messenger.sendMessage("pg.edu.pl", "m")).isSameAs(2);
		verify(mockMessageService).send("pg.edu.pl", "m");
	}
	
	@Test
	public void InvalidServerNameThrowException() throws MalformedRecipientException {
		when(mockMessageService.send(".eu", "content")).thenThrow(new MalformedRecipientException());
		assertThat(messenger.sendMessage(".eu", "content")).isSameAs(2);
		verify(mockMessageService).send(".eu", "content");
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		mockMessageService = null;
		messenger = null;
	}
}
