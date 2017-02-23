package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.modele.Pizza;

public class SupprimerPizzaOptionMenu  extends OptionMenu {
	
	PizzaDao pizzaDao = new PizzaDaoImpl();

	public SupprimerPizzaOptionMenu() {
		super(4, "Supprimer une pizza");
	}

	@Override
	public boolean execute(Scanner sc) {
		boolean execute = false;
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		for(Pizza pizza : pizzas){
			System.out.println(pizza.code + " -> " + pizza.nom + " (" + pizza.prix + " €)");
		}
		boolean fini = false;
		while(!fini){
			System.out.println("Veuillez choisir la pizza à supprimer (stop pour abandonner).");
			String codeChoisi = sc.next();
			int index = 0;
			if(!codeChoisi.equals("stop")){
				while(index < pizzas.length && !fini){
					if(codeChoisi.equals(pizzas[index].code)){
						fini = true;
					} else {
						index++;
					}
				}
				if(fini){
					try {
						pizzaDao.deletePizza(index);
						execute = true;
					} catch (PizzaException e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("Cette pizza n'existe pas.");
				}
			} else {
				fini = true;
			}
		}
		return execute;
	}

}
