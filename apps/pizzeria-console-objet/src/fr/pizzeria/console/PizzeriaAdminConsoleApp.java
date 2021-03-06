package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.modele.Pizza;

public class PizzeriaAdminConsoleApp {
	
	private static final int MAX_PIZZA = 100;

	public static void main(String[] args) {
		Pizza[] pizzas = new Pizza[MAX_PIZZA];
		pizzas[0] = new Pizza(0, "PEP", "P�p�roni", 12.50);
		Pizza.nbPizzas++;
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		Pizza.nbPizzas++;
		pizzas[2] = new Pizza(2, "REI", "La Reine", 11.50);
		Pizza.nbPizzas++;
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		Pizza.nbPizzas++;
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		Pizza.nbPizzas++;
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		Pizza.nbPizzas++;
		pizzas[6] = new Pizza(6, "ORI", "L�orientale", 13.50);
		Pizza.nbPizzas++;
		pizzas[7] = new Pizza(7, "IND", "L�indienne", 14.00);
		Pizza.nbPizzas++;
		int nbPizzas = 8;
		
		int choix;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("***** Pizzeria Administration *****\n"+
								"1. Lister les pizzas\n"+
								"2. Ajouter une nouvelle pizza\n"+
								"3. Mettre � jour une pizza\n"+
								"4. Supprimer une pizza\n"+
								"99. Sortir");
			choix = sc.nextInt();
			switch(choix){
			case 1:
				int i = 0;
				while(pizzas[i] != null){
					System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + " �)");
					i++;
				}
				System.out.println("-> " + Pizza.nbPizzas + " pizzas cr��es depuis l'initialisation du programme");
				break;
			case 2:
				if(nbPizzas < MAX_PIZZA){
					boolean codeDispo = true;
					do{
						System.out.println("Veuillez saisir le code");
						String code = sc.next();
						System.out.println("Veuillez saisir le nom (sans espace)");
						String nom = sc.next();
						System.out.println("Veuillez saisir le prix");
						double prix = sc.nextDouble();
						for(int m = 0; m < nbPizzas; m++){
							if(code.equals(pizzas[m].getCode())){
								codeDispo = false;
								m = nbPizzas;
							}
						}
						if(codeDispo){
							Pizza pizza = new Pizza(nbPizzas, code, nom, prix);
							pizzas[nbPizzas] = pizza;
							Pizza.nbPizzas++;
							nbPizzas++;
						} else {
							System.out.println("Le code " + code + " n'est pas disponible");
						}
					} while(!codeDispo);
				} else {
					System.out.println("La limite de" + MAX_PIZZA + " a �t� atteinte.");
				}
				break;
			case 3:
				int j = 0;
				while(pizzas[j] != null){
					System.out.println(pizzas[j].getCode() + " -> " + pizzas[j].getNom() + " (" + pizzas[j].getPrix() + " �)");
					j++;
				}
				boolean fini = false;
				while(!fini){
					int index = 0;
					System.out.println("Veuillez choisir la pizza � modifier (stop pour abandonner).");
					String codeChoisi = sc.next();
					if(!codeChoisi.equals("stop")){
						while(index < nbPizzas && !fini){
							if(codeChoisi.equals(pizzas[index].getCode())){
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
								for(int n = 0; n < nbPizzas; n++){
									if(newCode.equals(pizzas[n].getCode()) && n != index){
										codeDisponible = false;
										n = nbPizzas;
									}
								}
								if(codeDisponible){
									Pizza pizza = new Pizza(nbPizzas, newCode, newNom, newPrix);
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
					System.out.println(pizzas[k].getCode() + " -> " + pizzas[k].getNom() + " (" + pizzas[k].getPrix() + " �)");
					k++;
				}
				boolean termine = false;
				while(!termine){
					System.out.println("Veuillez choisir la pizza � supprimer (stop pour abandonner).");
					String codeVoulu = sc.next();
					int compteur = 0;
					if(!codeVoulu.equals("stop")){
						while(compteur < nbPizzas && !termine){
							if(codeVoulu.equals(pizzas[compteur].getCode())){
								termine = true;
							} else {
								compteur++;
							}
						}
						if(termine){
							while(compteur < nbPizzas-1){
								pizzas[compteur] = pizzas[compteur+1];
								compteur++;
							}
							pizzas[nbPizzas-1] = null;
							nbPizzas--;
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
		sc.close();
	}

}
