package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.exception.ChatClientException;
import dta.chat.history.HistoryFacade;
import dta.chat.model.ChatMessage;

public class ChatSocketProxy implements ChatSocket {
	
	private ClientSocket client;
	private HistoryFacade facade;

	public ChatSocketProxy(String ip, int port) throws ChatClientException {
		try {
			client = new ClientSocket(ip, port);
			facade = new HistoryFacade();
			facade.findLastMessages().forEach(messages -> System.out.println(messages.getLogin()+" : "+messages.getText()));
		} catch (IOException e) {
			throw new ChatClientException("Problème lors de la création du socket client", e);
		}
	}

	@Override
	public void close() throws ChatClientException {
		try {
			client.close();
		} catch (Exception e) {
			throw new ChatClientException("Impossible de fermer la connexion", e);
		}
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			client.sendObject(msg);
			facade.saveMessage(msg);
		} catch (IOException e) {
			throw new ChatClientException("Impossible d'envoyer le message", e);
		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		try {
			ChatMessage msg = (ChatMessage) client.readObject();
			facade.saveMessage(msg);
			return msg;
		} catch (ClassNotFoundException | IOException e) {
			throw new ChatClientException("La lecture du message a échoué", e);
		}
	}

}
