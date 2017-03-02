package dta.chat;

import java.util.Scanner;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatConversationModel;
import dta.chat.model.socket.ChatSocket;
import dta.chat.model.socket.ChatSocketImpl;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			try {
				ChatSocket client = new ChatSocketImpl("192.168.99.31", 1800);
				ChatConversationModel model = new ChatConversationModel(client);
				final ChatConsoleView view = new ChatConsoleView(sc);
				view.setAuthController((login) -> {
					model.setLogin(login);
				});
				model.addObserver(view);
				view.print();
				
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						while (true) {
							try {
								model.readMessage();
							} catch (ChatClientException e) {
								break;
							}
						}
					}
				});
				t.start();

				String msg = sc.nextLine();
				while (!msg.equals("STOP")) {
					msg = sc.nextLine();
					if(!msg.equals("STOP")){
						model.sendMessage(msg);
					}
				}
				try {
					client.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (ChatClientException e) {
				e.printStackTrace();
			}
		}
	}

}
