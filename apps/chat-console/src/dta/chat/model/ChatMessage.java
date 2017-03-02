package dta.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {
	
	private static final long serialVersionUID = 12L;
	
	private String login;
	private String text;
	
	public ChatMessage(String login, String text) {
		super();
		this.login = login;
		this.text = text;
	}

	public String getLogin() {
		return login;
	}
	
	public String getText() {
		return text;
	}

}
