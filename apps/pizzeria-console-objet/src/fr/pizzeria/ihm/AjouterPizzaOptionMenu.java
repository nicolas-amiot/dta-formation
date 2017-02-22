package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.modele.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	
	PizzaDao pizzaDao = new PizzaDaoImpl();

	public AjouterPizzaOptionMenu() {
		super(2, "Ajouter une nouvelle pizza");
	}

	@Override
	public boolean execute(Scanner sc) {
		boolean execute = false;
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		boolean codeDispo = true;
		do{
			System.out.println("Veuillez saisir le code");
			String code = sc.next();
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom = sc.next();
			System.out.println("Veuillez saisir le prix");
			double prix = sc.nextDouble();
			for(int i = 0; i < pizzas.length; i++){
				if(code.equals(pizzas[i].code)){
					codeDispo = false;
					i = pizzas.length;
				}
			}
			if(codeDispo){
				Pizza pizza = new Pizza(pizzas.length, code, nom, prix);
				execute =  pizzaDao.saveNewPizza(pizza);
			} else {
				System.out.println("Le code " + code + " n'est pas disponible");
			}
		} while(!codeDispo);
		return execute;
	}

}
