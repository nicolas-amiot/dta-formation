package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAjouter extends Menu {
	
	public MenuAjouter() {
		super();
		id = 2;
		libelle = "Ajouter une nouvelle pizza";
	}

	@Override
	public List<Object> operation(int nbPizzaMax, String[] codePizza, String[] nomPizza, float[] prixPizza, int nbPizza) {
		if(nbPizza < 100){
			Scanner sc = new Scanner(System.in);
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
		List<Object> list = new ArrayList<>();
		list.add(codePizza);
		list.add(nomPizza);
		list.add(prixPizza);
		list.add(nbPizza);
		return list;
	}

}
