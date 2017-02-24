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
		boolean execute = false;
		List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
		boolean codeDispo = true;
		do{
			System.out.println("Veuillez saisir le code");
			String code = ihmTools.getScanner().next();
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom = ihmTools.getScanner().next();
			System.out.println("Veuillez saisir le prix");
			double prix = ihmTools.getScanner().nextDouble();
			for(int i = 0; i < pizzas.size(); i++){
				if(code.equals(pizzas.get(i).getCode())){
					codeDispo = false;
					i = pizzas.size();
				}
			}
			if(codeDispo){
				Pizza pizza = new Pizza(pizzas.size(), code, nom, prix);
				try{
					ihmTools.getPizzaDao().save(pizza);
					execute =  true;
				} catch (DaoException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("Le code " + code + " n'est pas disponible");
			}
		} while(!codeDispo);
		return execute;
	}

}
