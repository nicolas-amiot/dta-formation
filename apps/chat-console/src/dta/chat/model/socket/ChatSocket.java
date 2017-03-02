package dta.chat.model.socket;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

public interface ChatSocket extends AutoCloseable {
	
	void sendMessage(ChatMessage msg) throws ChatClientException;
	ChatMessage readMessage() throws ChatClientException;

}
