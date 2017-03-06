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
		List<Pizza> pizzas = ihmTools.getPizzaDao().findAllPizzas();
		this.afficherPizzas(pizzas);
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
						Pizza pizza = this.saisirPizza(pizzas.size(), ihmTools.getScanner());
						codeDispo = true;
						for(int i = 0; i < pizzas.size(); i++){
							if(pizza.getCode().equals(pizzas.get(i).getCode()) && i != index){
								codeDispo = false;
								i = pizzas.size();
							}
						}
						if(codeDispo){
							try {
								ihmTools.getPizzaDao().update(codeChoisi, pizza);
							} catch (DaoException e) {
								System.out.println(e.getMessage());
							}
						} else {
							System.out.println("Le code " + pizza.getCode() + " n'est pas disponible");
						}
					} while(!codeDispo);
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
