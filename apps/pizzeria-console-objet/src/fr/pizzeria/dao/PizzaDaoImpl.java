package fr.pizzeria.dao;

import fr.pizzeria.modele.Pizza;

public class PizzaDaoImpl implements PizzaDao {
	
	public static Pizza[] pizzas = {
			new Pizza(0, "PEP", "Pépéroni", 12.50F),
			new Pizza(1, "MAR", "Margherita", 14.00F),
			new Pizza(2, "REI", "La Reine", 11.50F),
			new Pizza(3, "FRO", "La 4 fromages", 12.00F),
			new Pizza(4, "CAN", "La cannibale", 12.50F),
			new Pizza(5, "SAV", "La savoyarde", 13.00F),
			new Pizza(6, "ORI", "L’orientale", 13.50F),
			new Pizza(7, "IND", "L’indienne", 14.00F)
	};
	{Pizza.nbPizzas = pizzas.length;}

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		Pizza[] newPizzas = new Pizza[Pizza.nbPizzas];
		System.arraycopy(pizzas, 0, newPizzas, 0, Pizza.nbPizzas);
		newPizzas[Pizza.nbPizzas] = pizza;
		pizzas = newPizzas;
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
