package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		int nbPizzaMax = 100;
		String codePizza[] = new String[nbPizzaMax];
		String nomPizza[] = new String[nbPizzaMax];
		float prixPizza[] = new float[nbPizzaMax];
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
		int nbPizza = 8;
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
				while(codePizza[i] != null){
					System.out.println(codePizza[i] + " -> " + nomPizza[i] + " (" + prixPizza[i] + " €)");
					i++;
				}
				break;
			case 2:
				if(nbPizza < 100){
					boolean codeDispo = true;
					do{
						System.out.println("Veuillez saisir le code");
						String code = sc.next();
						System.out.println("Veuillez saisir le nom (sans espace)");
						String nom = sc.next();
						System.out.println("Veuillez saisir le prix");
						float prix = sc.nextFloat();
						for(int m = 0; m < nbPizza; m++){
							if(code.equals(codePizza[m])){
								codeDispo = false;
								m = nbPizza;
							}
						}
						if(codeDispo){
							codePizza[nbPizza] = code;
							nomPizza[nbPizza] = nom;
							prixPizza[nbPizza] = prix;
							nbPizza++;
						} else {
							System.out.println("Le code " + code + " n'est pas disponible");
						}
					} while(!codeDispo);
				} else {
					System.out.println("La limite de" + nbPizzaMax + " a été atteinte.");
				}
				break;
			case 3:
				int j = 0;
				while(codePizza[j] != null){
					System.out.println(codePizza[j] + " -> " + nomPizza[j] + " (" + prixPizza[j] + " €)");
					j++;
				}
				boolean fini = false;
				while(!fini){
					int index = 0;
					System.out.println("Veuillez choisir la pizza à modifier (stop pour abandonner).");
					String codeChoisi = sc.next();
					if(!codeChoisi.equals("stop")){
						while(index < nbPizza && !fini){
							if(codeChoisi.equals(codePizza[index])){
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
								float newPrix = sc.nextFloat();
								codeDisponible = true;
								for(int n = 0; n < nbPizza; n++){
									if(newCode.equals(codePizza[n]) && n != index){
										codeDisponible = false;
										n = nbPizza;
									}
								}
								if(codeDisponible){
									codePizza[index] = newCode;
									nomPizza[index] = newNom;
									prixPizza[index] = newPrix;
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
				while(codePizza[k] != null){
					System.out.println(codePizza[k] + " -> " + nomPizza[k] + " (" + prixPizza[k] + " €)");
					k++;
				}
				boolean termine = false;
				while(!termine){
					System.out.println("Veuillez choisir la pizza à supprimer (stop pour abandonner).");
					String codeVoulu = sc.next();
					int compteur = 0;
					if(!codeVoulu.equals("stop")){
						while(compteur < nbPizza && !termine){
							if(codeVoulu.equals(codePizza[compteur])){
								termine = true;
							} else {
								compteur++;
							}
						}
						if(termine){
							nbPizza--;
							while(compteur < nbPizza){
								codePizza[compteur] = codePizza[compteur+1];
								nomPizza[compteur] = nomPizza[compteur+1];
								prixPizza[compteur] = prixPizza[compteur+1];
							}
							codePizza[nbPizza] = null;
							nomPizza[nbPizza] = null;
							prixPizza[nbPizza] = 0;
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
