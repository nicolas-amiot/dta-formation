package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSupprimer extends Menu {
	
	public MenuSupprimer() {
		super();
		id = 4;
		libelle = "Supprimer une pizza";
	}

	@Override
	public List<Object> operation(int nbPizzaMax, String[] codePizza, String[] nomPizza, float[] prixPizza, int nbPizza) {
		Scanner sc = new Scanner(System.in);
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
						compteur++;
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
		List<Object> list = new ArrayList<>();
		list.add(codePizza);
		list.add(nomPizza);
		list.add(prixPizza);
		list.add(nbPizza);
		return list;
	}

}
