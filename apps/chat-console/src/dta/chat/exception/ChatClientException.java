package dta.chat.exception;

import java.io.IOException;

public class ChatClientException extends IOException {
	
	public ChatClientException(String message, Throwable cause) {
		super(message, cause);
	}

}
