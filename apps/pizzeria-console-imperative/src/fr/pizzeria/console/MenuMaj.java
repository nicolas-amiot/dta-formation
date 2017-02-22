package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuMaj extends Menu {
	
	public MenuMaj() {
		super();
		id = 3;
		libelle = "Mettre à jour une pizza";
	}

	@Override
	public List<Object> operation(int nbPizzaMax, String[] codePizza, String[] nomPizza, float[] prixPizza, int nbPizza) {
		Scanner sc = new Scanner(System.in);
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
		List<Object> list = new ArrayList<>();
		list.add(codePizza);
		list.add(nomPizza);
		list.add(prixPizza);
		list.add(nbPizza);
		return list;
	}

}
