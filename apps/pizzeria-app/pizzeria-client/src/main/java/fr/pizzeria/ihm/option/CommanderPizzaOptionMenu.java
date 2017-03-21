package fr.pizzeria.ihm.option;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Commande;
import fr.pizzeria.modele.CommandePizza;
import fr.pizzeria.modele.Pizza;

public class CommanderPizzaOptionMenu extends OptionMenu {

	public CommanderPizzaOptionMenu() {
		super("Commander une pizza");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		try {
			List<Pizza> pizzas = ihmTools.getPizzaDao().findAll();
			this.afficherPizzas(pizzas);
			List<CommandePizza> commandePizza = new ArrayList<>();
			String code;
			do{
				System.out.println("Code de la pizza souhaité ('exit' pour terminer la commande)");
				code = ihmTools.getScanner().next().toUpperCase();
				for(Pizza pizza : pizzas){
					if(code.equals(pizza.getCode())){
						commandePizza.add(new CommandePizza());
						break;
					}
				}
			} while(!code.equals("EXIT"));
			ihmTools.getCommandeDao().save(new Commande(this.generateString(), 0, new Date(), ihmTools.getLivreurDao().findAll().get(0), ihmTools.getClient(), commandePizza));
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
