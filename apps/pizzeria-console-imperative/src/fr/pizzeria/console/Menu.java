package fr.pizzeria.console;

import java.util.List;

public abstract class Menu {
	
	public int id;
	public String libelle;
	
	public abstract List<Object> operation(int nbPizzaMax, String codePizza[], String nomPizza[], float prixPizza[], int nbPizza);
	
}
