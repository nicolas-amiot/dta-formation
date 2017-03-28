package fr.pizzeria.ihm.option;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

public class SupprimerPizzaOptionMenu  extends OptionMenu {
	
	private Dao<Pizza, String> pizzaDao;
	private Scanner scanner;

	public SupprimerPizzaOptionMenu(Dao<Pizza, String> pizzaDao, Scanner scanner) {
		super("Supprimer une pizza");
		this.pizzaDao = pizzaDao;
		this.scanner = scanner;
	}

	@Override
	public boolean execute() {
		try{
			List<Pizza> pizzas = pizzaDao.findAll();
			this.afficherPizzas(pizzas);
			Pizza pizza = null;
			while(pizza == null){
				System.out.println("Veuillez choisir la pizza à supprimer (stop pour abandonner).");
				String code = scanner.next();
				pizza = pizzaDao.get(code);
				if(pizza != null){
					pizzaDao.delete(code);
				} else {
					System.out.println("Cette pizza n'existe pas.");
				}
			}
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
