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
		for(Pizza pizza : pizzas){
			System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + " €)");
		}
		System.out.println("-> " + Pizza.nbPizzas + " pizzas créées depuis l'initialisation du programme");
		return true;
	}

}
