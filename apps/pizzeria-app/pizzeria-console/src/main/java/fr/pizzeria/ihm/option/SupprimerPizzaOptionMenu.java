package fr.pizzeria.ihm.option;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class SupprimerPizzaOptionMenu  extends OptionMenu {

	public SupprimerPizzaOptionMenu() {
		super("Supprimer une pizza");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		try{
			List<Pizza> pizzas = ihmTools.getPizzaDao().findAll();
			this.afficherPizzas(pizzas);
			boolean fini = false;
			while(!fini){
				System.out.println("Veuillez choisir la pizza à supprimer (stop pour abandonner).");
				String codeChoisi = ihmTools.getScanner().next();
				int index = 0;
				if(!"stop".equals(codeChoisi)){
					while(index < pizzas.size() && !fini){
						if(codeChoisi.equals(pizzas.get(index).getCode())){
							fini = true;
						} else {
							index++;
						}
					}
					if(fini){
						ihmTools.getPizzaDao().delete(codeChoisi);
					} else {
						System.out.println("Cette pizza n'existe pas.");
					}
				} else {
					fini = true;
				}
			}
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
