package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;

public class MenuSortir extends Menu {

	public MenuSortir() {
		super();
		id = 99;
		libelle = "Sortir";
	}

	@Override
	public List<Object> operation(int nbPizzaMax, String[] codePizza, String[] nomPizza, float[] prixPizza, int nbPizza) {
		List<Object> list = new ArrayList<>();
		list.add(codePizza);
		list.add(nomPizza);
		list.add(prixPizza);
		list.add(nbPizza);
		return list;
	}
	
}
