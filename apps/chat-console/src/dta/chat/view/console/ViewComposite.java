package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

import dta.chat.controller.ChatAuthController;

public abstract class ViewComposite {

	private List<ViewComposite> children = new ArrayList<>();
	protected ChatAuthController authController;
	protected String user;

	public void add(ViewComposite view) {
		children.add(view);
	}

	/**
	 * Print
	 */
	public void print() {
		for (ViewComposite view : children) {
			view.print();
		}
	}
	
	public void setAuthController(ChatAuthController authController) {
		this.authController = authController;
		this.children.forEach(view -> view.setAuthController(authController));
	}

	public void setLogin(String login) {
		this.user = login;
		this.children.forEach(view -> view.setLogin(login));
	}

}
