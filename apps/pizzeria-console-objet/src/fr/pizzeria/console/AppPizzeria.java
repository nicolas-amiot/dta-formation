package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.ihm.*;

public class AppPizzeria {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choix;
		OptionMenu[] actions = {
				new ListerPizzasMenuOption(),
				new AjouterPizzaOptionMenu(),
				new ModifierPizzaOptionMenu(),
				new SupprimerPizzaOptionMenu(),
				new SortirOptionMenu()
		};
		Menu menu = new Menu("***** Pizzeria Administration *****", actions);
		do {
			menu.afficher();
			choix = sc.nextInt();
			for(OptionMenu optionMenu : actions){
				if(choix == optionMenu.getId()){
					optionMenu.execute(sc);
				}
			}
		} while(choix != actions[4].getId());
	}

}
