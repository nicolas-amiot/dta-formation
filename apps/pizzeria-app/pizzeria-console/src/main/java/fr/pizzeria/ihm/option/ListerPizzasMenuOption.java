package fr.pizzeria.ihm.option;

import java.util.List;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class ListerPizzasMenuOption extends OptionMenu {

	public ListerPizzasMenuOption() {
		super("Lister les pizzas");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
		this.afficherPizzas(pizzas);
		System.out.println("-> " + Pizza.nbPizzas + " pizzas créées depuis l'initialisation du programme");
		return false;
	}

}
