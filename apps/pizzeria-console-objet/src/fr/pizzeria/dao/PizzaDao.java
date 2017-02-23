package fr.pizzeria.dao;

import fr.pizzeria.exception.*;
import fr.pizzeria.modele.Pizza;

public interface PizzaDao {
	
	Pizza[] findAllPizzas();
	void saveNewPizza(Pizza pizza) throws PizzaException;
	void updatePizza(int idPizza, Pizza pizza) throws PizzaException;
	void deletePizza(int idPizza) throws PizzaException;

}
