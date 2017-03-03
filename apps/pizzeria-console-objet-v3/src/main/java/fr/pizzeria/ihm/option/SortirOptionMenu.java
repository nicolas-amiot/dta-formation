package fr.pizzeria.ihm.option;

import fr.pizzeria.ihm.tools.IhmTools;

public class SortirOptionMenu extends OptionMenu {

	public SortirOptionMenu() {
		super("Sortir");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		System.out.println("Fin du programme.");
		return true;
	}

	

}
