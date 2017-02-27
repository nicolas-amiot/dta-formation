package fr.pizzeria.ihm.option;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public abstract class OptionMenu {

	private String libelle;
	
	public OptionMenu(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
	public abstract boolean execute(IhmTools ihmTools);
	
	public void afficherPizzas(List<Pizza> pizzas){
		for(Pizza pizza : pizzas){
			System.out.println(pizza.toString());
		}
	}
	
	public Pizza saisirPizza(int nbPizza, Scanner sc){
		System.out.println("Veuillez saisir le code");
		String code = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = sc.next();
		System.out.println("Veuillez saisir le prix");
		double prix = sc.nextDouble();
		System.out.println("Veuillez saisir la cat�gorie");
		for(CategoriePizza cat : CategoriePizza.values()){
			System.out.print(cat+" ");
		}
		System.out.print("\n");
		CategoriePizza categorie = CategoriePizza.valueOf(sc.next().toUpperCase());
		return new Pizza(nbPizza, code, nom, prix, categorie);
	}

}
