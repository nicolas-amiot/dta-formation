package fr.pizzeria.ihm.option;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	public AjouterPizzaOptionMenu() {
		super(2, "Ajouter une nouvelle pizza");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		boolean execute = false;
		Pizza[] pizzas = ihmTools.getPizzaDao().findAllPizzas();
		boolean codeDispo = true;
		do{
			System.out.println("Veuillez saisir le code");
			String code = ihmTools.getScanner().next();
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom = ihmTools.getScanner().next();
			System.out.println("Veuillez saisir le prix");
			double prix = ihmTools.getScanner().nextDouble();
			for(int i = 0; i < pizzas.length; i++){
				if(code.equals(pizzas[i].getCode())){
					codeDispo = false;
					i = pizzas.length;
				}
			}
			if(codeDispo){
				Pizza pizza = new Pizza(pizzas.length, code, nom, prix);
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
