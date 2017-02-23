package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.modele.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	
	PizzaDao pizzaDao = new PizzaDaoImpl();

	public ModifierPizzaOptionMenu() {
		super(3, "Mettre à jour une pizza");
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
			int index = 0;
			System.out.println("Veuillez choisir la pizza à modifier (stop pour abandonner).");
			String codeChoisi = sc.next();
			if(!codeChoisi.equals("stop")){
				while(index < pizzas.length && !fini){
					if(codeChoisi.equals(pizzas[index].code)){
						fini = true;
					} else {
						index++;
					}
				}
				if(fini){
					boolean codeDispo;
					do{
						System.out.println("Veuillez saisir le code");
						String code = sc.next();
						System.out.println("Veuillez saisir le nom (sans espace)");
						String nom = sc.next();
						System.out.println("Veuillez saisir le prix");
						double prix = sc.nextDouble();
						codeDispo = true;
						for(int i = 0; i < pizzas.length; i++){
							if(code.equals(pizzas[i].code) && i != index){
								codeDispo = false;
								i = pizzas.length;
							}
						}
						if(codeDispo){
							Pizza pizza = new Pizza(pizzas.length, code, nom, prix);
							try {
								pizzaDao.updatePizza(index, pizza);
								execute = true;
							} catch (PizzaException e) {
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
