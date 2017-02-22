package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.modele.Pizza;

public class PizzeriaAdminConsoleApp {
	
	private static final int MAX_PIZZA = 100;

	public static void main(String[] args) {
		Pizza[] pizzas = new Pizza[MAX_PIZZA];
		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50F);
		Pizza.nbPizzas++;
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00F);
		Pizza.nbPizzas++;
		pizzas[2] = new Pizza(2, "REI", "La Reine", 11.50F);
		Pizza.nbPizzas++;
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00F);
		Pizza.nbPizzas++;
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50F);
		Pizza.nbPizzas++;
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00F);
		Pizza.nbPizzas++;
		pizzas[6] = new Pizza(6, "ORI", "L’orientale", 13.50F);
		Pizza.nbPizzas++;
		pizzas[7] = new Pizza(7, "IND", "L’indienne", 14.00F);
		Pizza.nbPizzas++;
		
		int choix;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("***** Pizzeria Administration *****\n"+
								"1. Lister les pizzas\n"+
								"2. Ajouter une nouvelle pizza\n"+
								"3. Mettre à jour une pizza\n"+
								"4. Supprimer une pizza\n"+
								"99. Sortir");
			choix = sc.nextInt();
			switch(choix){
			case 1:
				int i = 0;
				while(pizzas[i] != null){
					System.out.println(pizzas[i].code + " -> " + pizzas[i].nom + " (" + pizzas[i].prix + " €)");
					i++;
				}
				break;
			case 2:
				if(Pizza.nbPizzas < MAX_PIZZA){
					boolean codeDispo = true;
					do{
						System.out.println("Veuillez saisir le code");
						String code = sc.next();
						System.out.println("Veuillez saisir le nom (sans espace)");
						String nom = sc.next();
						System.out.println("Veuillez saisir le prix");
						double prix = sc.nextDouble();
						for(int m = 0; m < Pizza.nbPizzas; m++){
							if(code.equals(pizzas[m].code)){
								codeDispo = false;
								m = Pizza.nbPizzas;
							}
						}
						if(codeDispo){
							Pizza pizza = new Pizza(Pizza.nbPizzas, code, nom, prix);
							pizzas[Pizza.nbPizzas] = pizza;
							Pizza.nbPizzas++;
						} else {
							System.out.println("Le code " + code + " n'est pas disponible");
						}
					} while(!codeDispo);
				} else {
					System.out.println("La limite de" + MAX_PIZZA + " a été atteinte.");
				}
				break;
			case 3:
				int j = 0;
				while(pizzas[j] != null){
					System.out.println(pizzas[j].code + " -> " + pizzas[j].nom + " (" + pizzas[j].prix + " €)");
					j++;
				}
				boolean fini = false;
				while(!fini){
					int index = 0;
					System.out.println("Veuillez choisir la pizza à modifier (stop pour abandonner).");
					String codeChoisi = sc.next();
					if(!codeChoisi.equals("stop")){
						while(index < Pizza.nbPizzas && !fini){
							if(codeChoisi.equals(pizzas[index].code)){
								fini = true;
							} else {
								index++;
							}
						}
						if(fini){
							boolean codeDisponible;
							do{
								System.out.println("Veuillez saisir le code");
								String newCode = sc.next();
								System.out.println("Veuillez saisir le nom (sans espace)");
								String newNom = sc.next();
								System.out.println("Veuillez saisir le prix");
								double newPrix = sc.nextDouble();
								codeDisponible = true;
								for(int n = 0; n < Pizza.nbPizzas; n++){
									if(newCode.equals(pizzas[n].code) && n != index){
										codeDisponible = false;
										n = Pizza.nbPizzas;
									}
								}
								if(codeDisponible){
									Pizza pizza = new Pizza(Pizza.nbPizzas, newCode, newNom, newPrix);
									pizzas[index] = pizza;
								} else {
									System.out.println("Le code " + newCode + " n'est pas disponible");
								}
							} while(!codeDisponible);
						} else {
							System.out.println("Cette pizza n'existe pas.");
						}
					} else {
						fini = true;
					}
				}
				break;
			case 4:
				int k = 0;
				while(pizzas[k] != null){
					System.out.println(pizzas[k].code + " -> " + pizzas[k].nom + " (" + pizzas[k].prix + " €)");
					k++;
				}
				boolean termine = false;
				while(!termine){
					System.out.println("Veuillez choisir la pizza à supprimer (stop pour abandonner).");
					String codeVoulu = sc.next();
					int compteur = 0;
					if(!codeVoulu.equals("stop")){
						while(compteur < Pizza.nbPizzas && !termine){
							if(codeVoulu.equals(pizzas[compteur].code)){
								termine = true;
							} else {
								compteur++;
							}
						}
						if(termine){
							while(compteur < Pizza.nbPizzas-1){
								pizzas[compteur] = pizzas[compteur+1];
								compteur++;
							}
							pizzas[Pizza.nbPizzas-1] = null;
							Pizza.nbPizzas--;
						} else {
							System.out.println("Cette pizza n'existe pas.");
						}
					} else {
						termine = true;
					}
				}
				break;
			}
		} while(choix != 99);
		System.out.println("Fin du programme.");
	}

}
