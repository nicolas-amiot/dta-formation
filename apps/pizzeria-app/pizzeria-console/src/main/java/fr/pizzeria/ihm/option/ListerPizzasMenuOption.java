package fr.pizzeria.ihm.option;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class ListerPizzasMenuOption extends OptionMenu {

	public ListerPizzasMenuOption() {
		super("Lister les pizzas");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		try{
			List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
			this.afficherPizzas(pizzas);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
