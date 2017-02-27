package fr.pizzeria.ihm.option;

import java.util.List;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class ListerPizzasCategorieOptionMenu extends OptionMenu {

	public ListerPizzasCategorieOptionMenu() {
		super("Lister les pizzas par catégorie");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
		pizzas.sort((p1, p2) -> p1.getCategorie().compareTo(p2.getCategorie()));
		this.afficherPizzas(pizzas);
		return false;
	}

}
