package fr.pizzeria.ihm.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

@Controller
public class ImporterPizzaOptionMenu extends OptionMenu {
	
	private Dao<Pizza, String> pizzaDao;
	private Dao<Pizza, String> sourceDao;
	
	@Autowired
	public ImporterPizzaOptionMenu(@Qualifier("pizzaDao") Dao<Pizza, String> pizzaDao, @Qualifier("sourceDao") Dao<Pizza, String> sourceDao) {
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
