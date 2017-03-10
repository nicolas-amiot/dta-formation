package fr.pizzeria.ihm.option;

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
			System.out.println(e.getMessage());
		}
		return false;
	}

}
