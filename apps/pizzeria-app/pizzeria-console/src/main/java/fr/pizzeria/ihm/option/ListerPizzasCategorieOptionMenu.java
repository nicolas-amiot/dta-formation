package fr.pizzeria.ihm.option;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

public class ListerPizzasCategorieOptionMenu extends OptionMenu {
	
	private Dao<Pizza, String> pizzaDao;

	public ListerPizzasCategorieOptionMenu(Dao<Pizza, String> pizzaDao) {
		super("Lister les pizzas par catégorie");
		this.pizzaDao = pizzaDao;
	}

	@Override
	public boolean execute() {
		try {
			List<Pizza> pizzas = pizzaDao.findAll();
			pizzas.stream().collect(Collectors.groupingBy(Pizza::getCategorie)).forEach((cat, piz) -> {
				System.out.println("Dans la categorie " + cat + ":");
				this.afficherPizzas(piz);
				System.out.println("\n");
			});
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
