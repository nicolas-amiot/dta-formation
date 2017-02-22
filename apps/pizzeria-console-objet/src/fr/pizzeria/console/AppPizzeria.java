package fr.pizzeria.console;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.ihm.ListerPizzasMenuOption;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.NouvellePizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;

public class AppPizzeria {
	
	public static void main(String[] args) {
		int choix;
		Scanner sc = new Scanner(System.in);
		OptionMenu[] actions = {new ListerPizzasMenuOption(), new NouvellePizzaOptionMenu()};
		Menu menu = new Menu("***** Pizzeria Administration *****", actions);
		do {
			menu.afficher();
			choix = sc.nextInt();
			for(OptionMenu optionMenu : actions){
				if(choix == menu.id){
					List<Object>list = menu.operation(nbPizzaMax, codePizza, nomPizza, prixPizza, nbPizza);
					codePizza = (String[]) list.get(0);
					nomPizza = (String[]) list.get(1);
					prixPizza = (float[]) list.get(2);
					nbPizza = (int) list.get(3);
				}
			}
		} while(choix != 99);
		System.out.println("Fin du programme.");
	}

}
