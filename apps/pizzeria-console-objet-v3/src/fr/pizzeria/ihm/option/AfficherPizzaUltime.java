package fr.pizzeria.ihm.option;

import java.util.List;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class AfficherPizzaUltime extends OptionMenu {

	public AfficherPizzaUltime() {
		super("Afficher la pizza la plus cher");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
		pizzas.sort((p1, p2) -> ((Double) p1.getPrix()).compareTo(((Double) p2.getPrix())));
		Pizza pizza = pizzas.get(pizzas.size() - 1);
		System.out.println(pizza);
		return false;
	}

}
