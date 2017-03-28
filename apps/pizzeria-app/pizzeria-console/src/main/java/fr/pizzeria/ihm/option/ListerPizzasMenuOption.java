package fr.pizzeria.ihm.option;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

@Controller
public class ListerPizzasMenuOption extends OptionMenu {
	
	private Dao<Pizza, String> pizzaDao;

	@Autowired
	public ListerPizzasMenuOption(@Qualifier("pizzaDao") Dao<Pizza, String> pizzaDao) {
		super("Lister les pizzas");
		this.pizzaDao = pizzaDao;
	}

	@Override
	public boolean execute() {
		try{
			List<Pizza> pizzas = pizzaDao.findAll();
			this.afficherPizzas(pizzas);
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
