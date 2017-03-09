package fr.pizzeria.ihm.option;

import java.util.Comparator;
import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class AfficherPizzaUltime extends OptionMenu {

	public AfficherPizzaUltime() {
		super("Afficher la pizza la plus cher");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		try {
			List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
			Pizza pizza = pizzas.stream().max(Comparator.comparing(Pizza::getPrix)).get();
			System.out.println(pizza);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
