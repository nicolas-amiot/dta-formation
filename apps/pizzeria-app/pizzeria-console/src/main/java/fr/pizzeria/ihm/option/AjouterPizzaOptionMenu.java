package fr.pizzeria.ihm.option;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.*;
import fr.pizzeria.modele.Pizza;

@Controller
public class AjouterPizzaOptionMenu extends OptionMenu {
	
	private Dao<Pizza, String> pizzaDao;
	private Scanner scanner;

	@Autowired
	public AjouterPizzaOptionMenu(@Qualifier("pizzaDao") Dao<Pizza, String> pizzaDao, Scanner scanner) {
		super("Ajouter une nouvelle pizza");
		this.pizzaDao = pizzaDao;
		this.scanner = scanner;
	}

	@Override
	public boolean execute() {
		try {
			Pizza pizza = null;
			while(pizza == null){
				pizza = this.saisirPizza(scanner);
				if(pizzaDao.get(pizza.getCode()) == null){
					pizzaDao.save(pizza);
				} else {
					System.out.println("Le code " + pizza.getCode() + " n'est pas disponible");
					pizza = null;
				}
			}
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
