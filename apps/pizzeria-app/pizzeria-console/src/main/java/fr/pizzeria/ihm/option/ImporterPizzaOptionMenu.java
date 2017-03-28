package fr.pizzeria.ihm.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

public class ImporterPizzaOptionMenu extends OptionMenu {
	
	private Dao<Pizza, String> pizzaDao;
	private Dao<Pizza, String> sourceDao;
	
	public ImporterPizzaOptionMenu(Dao<Pizza, String> pizzaDao, Dao<Pizza, String> sourceDao) {
		super("Importer les données de la source");
		this.pizzaDao = pizzaDao;
		this.sourceDao = sourceDao;
	}

	@Override
	public boolean execute() {
		try {
			pizzaDao.importData(sourceDao);
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
