package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleLoginView extends ViewComposite {
	
	private Scanner sc;

	public ChatConsoleLoginView(Scanner sc) {
		this.sc = sc;
	}
	
	@Override
	public void print() {
		System.out.print("Veuillez saisir votre login : ");
		String login = sc.next();
		this.authController.authenticate(login);
	}

}
