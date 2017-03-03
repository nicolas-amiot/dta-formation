package dta.chat.model;

import dta.chat.exception.ChatClientException;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.Proxy;

public class ChatConversationModel extends ChatObservable<ChatMessage> {
	
	private String login;
	private Proxy proxy;
	
	public ChatConversationModel(Proxy proxy) {
		this.proxy = proxy;
	}
	
	public void setLogin(String login) {
		this.login = login;
		notifyObservers(new ChatMessage("Bienvenue", login));
	}

	public void sendMessage(String msg) throws ChatClientException {
		ChatMessage msg2 = new ChatMessage(login, msg);
		proxy.sendMessage(msg2);
		notifyObservers(msg2);
	}

	public ChatMessage readMessage() throws ChatClientException {
		ChatMessage msg = proxy.readMessage();
		notifyObservers(msg);
		return msg;
	}

}
