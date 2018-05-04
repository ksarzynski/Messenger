package com.example.mockdemo.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.mockdemo.messenger.MockMessageService;

public class MessageAppTest {

	private MockMessageService mockMessageService;
	private Messenger messenger;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER_SHORT = ".pl";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@BeforeEach
	public void setUp() throws Exception {
		mockMessageService = new MockMessageService();
		messenger = new Messenger(mockMessageService);
	}
	
	@Test
	public void ValidConnectionIsNotNull() {
		mockMessageService.setConnection(true);
		int response = messenger.testConnection(VALID_SERVER);
		assertNotNull(response);
	}
			
	@Test
	public void ValidConnectionReturns0() {
		mockMessageService.setConnection(true);
		int response = messenger.testConnection(VALID_SERVER);
		assertEquals(0, response);
	}
			
	@Test
	public void ValidConnectionNotEquals1() {
		mockMessageService.setConnection(true);
		int response = messenger.testConnection(VALID_SERVER);
		assertNotEquals(1, response);
	}
	
	@Test
	public void ValidConnectionNotSame1() {
		mockMessageService.setConnection(true);
		int response = messenger.testConnection(VALID_SERVER);
		assertNotSame(1, response);
	}
		
	@Test
	public void NullConnectionThrowsException2() {
	    assertThrows(NullPointerException.class,
	            ()->{
	            	mockMessageService.setConnection(false);
	        		int response = messenger.testConnection(null);
	            });
	}	
	
	@Test
	public void InvalidConnectionReturns1() {
		mockMessageService.setConnection(true);
		int response = messenger.testConnection(INVALID_SERVER);
		assertEquals(1, response);
	}
	
	@Test
	public void ValidServerWithFalseConnectionReturns1() {
		int response = messenger.testConnection(VALID_SERVER);
		assertEquals(1, response);
	}
	
	@Test
	public void ValidMessageReturnsNotNull() {
		mockMessageService.setMessageIsSent(true);
		int response = messenger.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertNotNull(response);
	}
	
	@Test
	public void ValidMessageReturns0() {
		mockMessageService.setMessageIsSent(true);
		int response = messenger.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, response);
	}
	
	@Test
	public void InvalidServerReturns2() {
		mockMessageService.setMessageIsSent(true);
		int response = messenger.sendMessage(INVALID_SERVER_SHORT, VALID_MESSAGE);
		assertEquals(2, response);
	}
	
	@Test
	public void InvalidMessageReturns2() {
		mockMessageService.setMessageIsSent(true);
		int response = messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, response);
	}
	
	@Test
	public void InvalidMessageAndServerReturns2() {
		mockMessageService.setMessageIsSent(true);
		int response = messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, response);
	}
	
	@Test
	public void ValidServerAndMessageNotSentReturns1() {
		mockMessageService.setMessageIsSent(false);
		int response = messenger.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, response);
	}
	
	@Test
	public void InvalidServerAndMessageReturns2() {
		mockMessageService.setMessageIsSent(false);
		int response = messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, response);
	}
	
	@Test
	public void InvalidServerAndMessageReturns2_2() {
		mockMessageService.setMessageIsSent(false);
		int response = messenger.sendMessage(INVALID_SERVER_SHORT, INVALID_MESSAGE);
		assertEquals(2, response);
	}
	
	@Test
	public void InvalidServerNotSentReturns2() {
		mockMessageService.setMessageIsSent(false);
		int response = messenger.sendMessage(INVALID_SERVER_SHORT, VALID_MESSAGE);
		assertEquals(2, response);
	}
	
	@Test
	public void InvalidMessageNotSentReturns2() {
		mockMessageService.setMessageIsSent(false);
		int response = messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, response);
	}
	
	@Test
	public void NullServerAndNullMessageReturns2() {
		mockMessageService.setMessageIsSent(true);
		int response = messenger.sendMessage(null, null);
		assertEquals(2, response);
	}
	
	@Test
	public void ValidServerAndNullMessageReturns2() {
		mockMessageService.setMessageIsSent(true);
		int response = messenger.sendMessage(VALID_SERVER, null);
		assertEquals(2, response);
	}
	
	@Test
	public void NullServerAndValidMessageReturns2() {
		mockMessageService.setMessageIsSent(true);
		int response = messenger.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, response);
	}
	
	@Test
	public void connectionIsTrue() {
		mockMessageService.setConnection(true);
		boolean response = mockMessageService.getConnected();
		assertTrue(response);
	}
	
	@Test
	public void connectionIsFalse() {
		mockMessageService.setConnection(false);
		boolean response = mockMessageService.getConnected();
		assertFalse(response);
	}
	
	@Test
	public void sentMessageIsTrue() {
		mockMessageService.setMessageIsSent(true);
		boolean response = mockMessageService.getSent();
		assertTrue(response);
	}
	
	@Test
	public void sentMessageIsFalse() {
		mockMessageService.setMessageIsSent(false);
		boolean response = mockMessageService.getSent();
		assertFalse(response);
	}
				
	@AfterEach
	public void tearDown() throws Exception {
		mockMessageService = null;
		messenger = null;
	}
}
