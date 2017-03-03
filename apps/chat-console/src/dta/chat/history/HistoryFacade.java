package dta.chat.history;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

public class HistoryFacade {
	
	public List<ChatMessage> findLastMessages() throws ChatClientException {
		List<ChatMessage> messages = new ArrayList<>();
		try(Stream<Path> files = Files.list(Paths.get("messages"))){
			Charset cs = Charset.forName("Cp1252"); // "Cp1252" is Windows ANSI
			Object[] contenuFichier = Files.lines(Paths.get("messages", "DTA.txt"), cs).toArray();
			for(int i = 0; i < contenuFichier.length; i++){
				String login = contenuFichier[i].toString().split(";")[0];
				String text = contenuFichier[i].toString().split(";")[1];
				messages.add(new ChatMessage(login, text));
			}
		} catch(IOException e){
			throw new ChatClientException("Les messages contenu dans le fichier n'ont pas pu être lu", e);
		}
		return messages;
	}
	
	public void saveMessage(ChatMessage message) throws ChatClientException {
		try {
			Files.write(Paths.get("messages", "DTA.txt"), (message.getLogin() + ";" + message.getText() + "\r\n").getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new ChatClientException("Erreur lors de l'écriture du message dans le fichier", e);
		}
	}

}
