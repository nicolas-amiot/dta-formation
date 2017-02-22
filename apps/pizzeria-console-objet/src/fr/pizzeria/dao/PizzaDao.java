package fr.pizzeria.dao;

import fr.pizzeria.modele.Pizza;

public interface PizzaDao {
	
	Pizza[] findAllPizzas();
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(int idPizza, Pizza pizza);
	boolean deletePizza(int idPizza);

}
