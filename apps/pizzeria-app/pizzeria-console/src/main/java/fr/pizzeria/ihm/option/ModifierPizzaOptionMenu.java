package fr.pizzeria.ihm.option;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	
	private Dao<Pizza, String> pizzaDao;
	private Scanner scanner;

	public ModifierPizzaOptionMenu(Dao<Pizza, String> pizzaDao, Scanner scanner) {
		super("Mettre à jour une pizza");
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
				System.out.println("Veuillez choisir la pizza à modifier (stop pour abandonner).");
				String code = scanner.next();
				pizza = pizzaDao.get(code);
				if(pizza != null){
					pizza = this.saisirPizza(scanner);
					if(code.equals(pizza.getCode()) || pizzaDao.get(pizza.getCode()) == null){
						pizzaDao.update(code, pizza);
					} else {
						System.out.println("Le code " + pizza.getCode() + " n'est pas disponible");
						pizza = null;
					}
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
