package fr.pizzeria.ihm.option;

import org.springframework.stereotype.Controller;

@Controller
public class SortirOptionMenu extends OptionMenu {

	public SortirOptionMenu() {
		super("Sortir");
	}

	@Override
	public boolean execute() {
		System.out.println("Fin du programme.");
		return true;
	}

	

}
