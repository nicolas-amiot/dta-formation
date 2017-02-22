package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;

public class MenuLister extends Menu {

	public MenuLister() {
		super();
		id = 1;
		libelle = "Lister les pizzas";
	}

	@Override
	public List<Object> operation(int nbPizzaMax, String[] codePizza, String[] nomPizza, float[] prixPizza, int nbPizza) {
		int i = 0;
		while(codePizza[i] != null){
			System.out.println(codePizza[i] + " -> " + nomPizza[i] + " (" + prixPizza[i] + " €)");
			i++;
		}
		List<Object> list = new ArrayList<>();
		list.add(codePizza);
		list.add(nomPizza);
		list.add(prixPizza);
		list.add(nbPizza);
		return list;
	}
	
}
