package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppPizza {
	
	public static void main(String[] args) {
		int nbPizzaMax = 100;
		String codePizza[] = new String[nbPizzaMax];
		String nomPizza[] = new String[nbPizzaMax];
		float prixPizza[] = new float[nbPizzaMax];
		int nbPizza = 0;
		codePizza[0] = "PEP";
		nomPizza[0] = "Pépéroni";
		prixPizza[0] = 12.50F;
		codePizza[1] = "MAR";
		nomPizza[1] = "Margherita";
		prixPizza[1] = 14.00F;
		codePizza[2] = "REI";
		nomPizza[2] = "La Reine";
		prixPizza[2] = 11.50F;
		codePizza[3] = "FRO";
		nomPizza[3] = "La 4 fromages";
		prixPizza[3] = 12.00F;
		codePizza[4] = "CAN";
		nomPizza[4] = "La cannibale";
		prixPizza[4] = 12.50F;
		codePizza[5] = "SAV";
		nomPizza[5] = "La savoyarde";
		prixPizza[5] = 13.00F;
		codePizza[6] = "ORI";
		nomPizza[6] = "L’orientale";
		prixPizza[6] = 13.50F;
		codePizza[7] = "IND";
		nomPizza[7] = "L’indienne";
		prixPizza[7] = 14.00F;
		nbPizza = 8;
		int choix;
		Scanner sc = new Scanner(System.in);
		List<Menu> menus = new ArrayList<>();
		menus.add(new MenuLister());
		menus.add(new MenuAjouter());
		menus.add(new MenuMaj());
		menus.add(new MenuSupprimer());
		menus.add(new MenuSortir());
		do {
			System.out.println("***** Pizzeria Administration *****");
			for(Menu menu : menus){
				System.out.println(menu.id + ". " + menu.libelle);
			}
			choix = sc.nextInt();
			for(Menu menu : menus){
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
