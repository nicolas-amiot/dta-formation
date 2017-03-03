package dta.chat.model.socket;

import dta.chat.exception.ChatClientException;
import dta.chat.history.HistoryFacade;
import dta.chat.model.ChatMessage;

public class Proxy {
	
	ChatSocket connection;
	private HistoryFacade facade;

	public Proxy(String ip, int port) throws ChatClientException {
		connection = new ChatSocketImpl(ip, port);
		facade = new HistoryFacade();
		afficherHistorique();
	}
	
	public void close() throws ChatClientException {
		try {
			connection.close();
		} catch (Exception e) {
			throw new ChatClientException("Impossible de fermer la connexion", e);
		}
	}

	public void sendMessage(ChatMessage msg) throws ChatClientException {
		connection.sendMessage(msg);
		facade.saveMessage(msg);
	}

	public ChatMessage readMessage() throws ChatClientException {
		ChatMessage msg = (ChatMessage) connection.readMessage();
		facade.saveMessage(msg);
		return msg;
	}

	public void afficherHistorique() throws ChatClientException {
		facade = new HistoryFacade();
		facade.findLastMessages().forEach(messages -> System.out.println(messages.getLogin()+" : "+messages.getText()));
	}

}
