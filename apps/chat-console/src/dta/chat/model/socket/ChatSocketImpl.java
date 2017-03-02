package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket {

	private ClientSocket client;

	public ChatSocketImpl(String ip, int port) throws ChatClientException {
		try {
			client = new ClientSocket(ip, port);
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
		} catch (IOException e) {
			throw new ChatClientException("Impossible d'envoyer le message", e);
		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		try {
			return (ChatMessage) client.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new ChatClientException("La lecture du message a échoué", e);
		}
	}

}
