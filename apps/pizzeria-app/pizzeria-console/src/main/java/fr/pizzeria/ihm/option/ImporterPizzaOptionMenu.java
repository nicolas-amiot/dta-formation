package fr.pizzeria.ihm.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;

public class ImporterPizzaOptionMenu extends OptionMenu {
	
	public ImporterPizzaOptionMenu() {
		super("Importer les données de la source");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		try {
			ihmTools.getPizzaDao().importData(ihmTools.getSourceDao());
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
