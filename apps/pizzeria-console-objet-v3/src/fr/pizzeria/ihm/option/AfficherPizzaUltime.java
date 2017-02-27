package fr.pizzeria.ihm.option;

import fr.pizzeria.ihm.tools.IhmTools;

public class AfficherPizzaUltime extends OptionMenu {

	public AfficherPizzaUltime() {
		super("Afficher la pizza la plus cher");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		return false;
	}

}
