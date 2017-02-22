package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.modele.Pizza;

public class ListerPizzasMenuOption extends OptionMenu {
	
	PizzaDao pizzaDao = new PizzaDaoImpl();

	public ListerPizzasMenuOption() {
		super(1, "Lister les pizzas");
	}

	@Override
	public boolean execute() {
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		for(Pizza pizza : pizzas){
			System.out.println(pizza.code + " -> " + pizza.nom + " (" + pizza.prix + " €)");
		}
		return true;
	}

}
