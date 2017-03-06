package fr.pizzeria.ihm.option;

import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class ListerPizzasCategorieOptionMenu extends OptionMenu {

	public ListerPizzasCategorieOptionMenu() {
		super("Lister les pizzas par catégorie");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
		pizzas.stream().collect(Collectors.groupingBy(Pizza::getCategorie)).forEach((cat, piz) -> {
			System.out.println("Dans la categorie " + cat + ":");
			this.afficherPizzas(piz);
			System.out.println("\n");
		});
		return false;
	}

}
