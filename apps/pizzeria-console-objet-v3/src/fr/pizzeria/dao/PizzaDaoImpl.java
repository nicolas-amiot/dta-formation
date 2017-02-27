package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.*;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class PizzaDaoImpl implements Dao<Pizza, Integer> {
	
	private List<Pizza> pizzas = new ArrayList<>();
		
	public PizzaDaoImpl() {
		pizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(6, "ORI", "L’orientale", 13.50, CategoriePizza.POISSON));
		pizzas.add(new Pizza(7, "IND", "L’indienne", 14.00, CategoriePizza.VIANDE));
		Pizza.nbPizzas = pizzas.size();
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return new ArrayList<>(pizzas);
	}

	@Override
	public void save(Pizza pizza) throws DaoException {
		if(pizza.getCode().length() > 3){
			throw new SaveDaoException("Le code est trop long");
		}
		pizzas.add(pizza);
		Pizza.nbPizzas++;
	}

	@Override
	public void update(Integer idPizza, Pizza pizza) throws DaoException {
		if(idPizza <= 0){
			throw new UpdateDaoException("L'identifiant doit être positif");
		}
		if(pizza.getCode().length() > 3){
			throw new UpdateDaoException("Le code modifié est trop long");
		}
		pizzas.set(idPizza.intValue(), pizza);
	}

	@Override
	public void delete(Integer idPizza) throws DaoException {
		pizzas.remove(idPizza.intValue());
	}

}
