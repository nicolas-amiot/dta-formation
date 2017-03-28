package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import fr.pizzeria.ihm.option.OptionMenu;

public class Menu {
	
	private String titre;
	private Map<Integer, OptionMenu> actions;
	private Scanner scanner;
	
	public Menu(String titre, Map<Integer, OptionMenu> actions, Scanner scanner) {
		this.titre = titre;
		this.actions = actions;
		this.scanner = scanner;
	}

	public void afficher() {
		System.out.println(titre);
		for(Entry<Integer, OptionMenu> entry : actions.entrySet()){
			System.out.println(entry.getKey() + ". " + entry.getValue().getLibelle());
		}
	}
	
	public void demmarer(){
		int choix;
		boolean termine = false;
		do {
			this.afficher();
			choix = scanner.nextInt();
			OptionMenu action = actions.get(choix);
			if(action != null){
				termine = action.execute();
			}
		} while(!termine);
	}

}
