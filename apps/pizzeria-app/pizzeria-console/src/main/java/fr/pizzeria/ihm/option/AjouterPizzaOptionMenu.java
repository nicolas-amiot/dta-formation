package fr.pizzeria.ihm.option;

import java.util.List;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	public AjouterPizzaOptionMenu() {
		super("Ajouter une nouvelle pizza");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		List<Pizza> pizzas;
		try {
			pizzas = ihmTools.getPizzaDao().findAllPizzas();
			boolean codeDispo = true;
			do{
				Pizza pizza = this.saisirPizza(pizzas.size(), ihmTools.getScanner());
				for(int i = 0; i < pizzas.size(); i++){
					if(pizza.getCode().equals(pizzas.get(i).getCode())){
						codeDispo = false;
						i = pizzas.size();
					}
				}
				if(codeDispo){
					ihmTools.getPizzaDao().save(pizza);
				} else {
					System.out.println("Le code " + pizza.getCode() + " n'est pas disponible");
				}
			} while(!codeDispo);
		} catch (DaoException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

}
