package fr.pizzeria.ihm.option;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class SupprimerPizzaOptionMenu  extends OptionMenu {

	public SupprimerPizzaOptionMenu() {
		super("Supprimer une pizza");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
		for(Pizza pizza : pizzas){
			System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " [" + pizza.getCategorie().getLibelle() + "] (" + pizza.getPrix() + " €)");
		}
		boolean fini = false;
		while(!fini){
			System.out.println("Veuillez choisir la pizza à supprimer (stop pour abandonner).");
			String codeChoisi = ihmTools.getScanner().next();
			int index = 0;
			if(!codeChoisi.equals("stop")){
				while(index < pizzas.size() && !fini){
					if(codeChoisi.equals(pizzas.get(index).getCode())){
						fini = true;
					} else {
						index++;
					}
				}
				if(fini){
					try {
						ihmTools.getPizzaDao().delete(index);
					} catch (DaoException e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("Cette pizza n'existe pas.");
				}
			} else {
				fini = true;
			}
		}
		return false;
	}

}
