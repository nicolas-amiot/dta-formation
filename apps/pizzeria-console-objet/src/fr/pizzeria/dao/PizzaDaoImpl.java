package fr.pizzeria.dao;

import fr.pizzeria.exception.*;
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
	public void saveNewPizza(Pizza pizza) throws PizzaException {
		if(pizza.code.length() > 3){
			throw new SavePizzaException("Le code est trop long");
		}
		Pizza[] newPizzas = new Pizza[pizzas.length+1];
		System.arraycopy(pizzas, 0, newPizzas, 0, pizzas.length);
		newPizzas[pizzas.length] = pizza;
		pizzas = newPizzas;
		Pizza.nbPizzas++;
	}

	@Override
	public void updatePizza(int idPizza, Pizza pizza) throws PizzaException {
		if(pizza.code.length() > 3){
			throw new UpdatePizzaException("Le code modifié est trop long");
		}
		pizzas[idPizza] = pizza;
	}

	@Override
	public void deletePizza(int idPizza) throws PizzaException {
		if(idPizza <= 0){
			throw new DeletePizzaException("L'identifiant doit être positif");
		}
		Pizza[] newPizzas = new Pizza[pizzas.length-1];
		for(int i = 0; i < idPizza; i++){
			newPizzas[i] = pizzas[i];
		}
		while(idPizza < pizzas.length-1){
			newPizzas[idPizza] = pizzas[idPizza+1];
			idPizza++;
		}
		pizzas = newPizzas;
	}

}
