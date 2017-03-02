package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

public class ChatConsoleView extends ViewComposite implements ChatObserver<ChatMessage>{

	public ChatConsoleView(Scanner sc) {
		this.add(new ChatConsoleTitleView());
		this.add(new ChatConsoleLoginView(sc));
		this.add(new ChatConsoleConversationView());
	}
	
	@Override
	public void update(ChatObservable<ChatMessage> obs, ChatMessage msg) {
		System.out.println(msg.getLogin() + " : " + msg.getText());
	}

}
