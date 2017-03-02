package dta.chat.controller;

import dta.chat.view.console.ViewComposite;

public class ChatAuthControllerImpl implements ChatAuthController {
	
	private ViewComposite view;

	public ChatAuthControllerImpl(ViewComposite view) {
		super();
		this.view = view;
	}

	@Override
	public void authenticate(String login) {
		view.setLogin(login);
	}

}
