package fr.pizzeria.ihm.option;

import java.util.Arrays;
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
		/*
		for(Pizza pizza : pizzas){
			System.out.println(pizza);
		}
		*/
		pizzas.forEach(System.out::println);
	}
	
	public Pizza saisirPizza(int nbPizza, Scanner sc){
		System.out.println("Veuillez saisir le code");
		String code = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = sc.next();
		System.out.println("Veuillez saisir le prix");
		double prix = sc.nextDouble();
		System.out.println("Veuillez saisir la catégorie");
		/*
		for(CategoriePizza categorie : CategoriePizza.values()){
			System.out.print(categorie + " ");
		}
		*/
		Arrays.asList(CategoriePizza.values()).forEach(categorie -> System.out.print(categorie + " "));
		System.out.print("\n");
		CategoriePizza categorie = CategoriePizza.valueOf(sc.next().toUpperCase());
		return new Pizza(code, nom, prix, categorie);
	}

}
