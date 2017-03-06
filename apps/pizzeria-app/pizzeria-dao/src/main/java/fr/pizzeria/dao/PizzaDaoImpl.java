package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import fr.pizzeria.exception.*;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class PizzaDaoImpl implements Dao<Pizza, String> {
	
	private List<Pizza> pizzas = new ArrayList<>();
		
	public PizzaDaoImpl() {
		pizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
		Pizza.nbPizzas = pizzas.size();
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return new ArrayList<>(pizzas);
	}

	@Override
	public void save(Pizza pizza) throws DaoException {
		if(pizza.getCode().length() < 3){
			throw new SaveDaoException("Le code est trop court");
		}
		pizzas.add(pizza);
		Pizza.nbPizzas++;
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws DaoException {
		if(pizza.getCode().length() > 3){
			throw new UpdateDaoException("L'identifiant doit être positif");
		}
		int index = IntStream.range(0, pizzas.size())
        .filter(i -> pizzas.get(i).getCode().equals(codePizza))
        .findFirst().getAsInt();
		pizzas.set(index, pizza);
	}

	@Override
	public void delete(String codePizza) throws DaoException {
		if(codePizza.length() > 3){
			throw new DeleteDaoException("L'identifiant doit être positif");
		}
		pizzas.removeIf(p -> p.getCode().equals(codePizza));
	}

}
