package fr.pizzeria.ihm.option;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	public ModifierPizzaOptionMenu() {
		super("Mettre à jour une pizza");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		boolean execute = false;
		List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
		for(Pizza pizza : pizzas){
			System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + " €)");
		}
		boolean fini = false;
		while(!fini){
			int index = 0;
			System.out.println("Veuillez choisir la pizza à modifier (stop pour abandonner).");
			String codeChoisi = ihmTools.getScanner().next();
			if(!codeChoisi.equals("stop")){
				while(index < pizzas.size() && !fini){
					if(codeChoisi.equals(pizzas.get(index).getCode())){
						fini = true;
					} else {
						index++;
					}
				}
				if(fini){
					boolean codeDispo;
					do{
						System.out.println("Veuillez saisir le code");
						String code = ihmTools.getScanner().next();
						System.out.println("Veuillez saisir le nom (sans espace)");
						String nom = ihmTools.getScanner().next();
						System.out.println("Veuillez saisir le prix");
						double prix = ihmTools.getScanner().nextDouble();
						codeDispo = true;
						for(int i = 0; i < pizzas.size(); i++){
							if(code.equals(pizzas.get(i).getCode()) && i != index){
								codeDispo = false;
								i = pizzas.size();
							}
						}
						if(codeDispo){
							Pizza pizza = new Pizza(pizzas.size(), code, nom, prix);
							try {
								ihmTools.getPizzaDao().update(index, pizza);
								execute = true;
							} catch (DaoException e) {
								System.out.println(e.getMessage());
							}
						} else {
							System.out.println("Le code " + code + " n'est pas disponible");
						}
					} while(!codeDispo);
				} else {
					System.out.println("Cette pizza n'existe pas.");
				}
			} else {
				fini = true;
				execute = true;
			}
		}
		return execute;
	}

}
