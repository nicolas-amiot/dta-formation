package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Map.Entry;

import fr.pizzeria.ihm.option.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class Menu {
	
	private String titre;
	private Map<Integer, OptionMenu> actions;
	private IhmTools ihmTools;
	
	public Menu(IhmTools ihmTools, String titre, Map<Integer, OptionMenu> actions) {
		this.ihmTools = ihmTools;
		this.titre = titre;
		this.actions = actions;
	}

	public void afficher() {
		System.out.println(titre);
		for(Entry<Integer, OptionMenu> entry : actions.entrySet()){
			System.out.println(entry.getKey() + ". " + entry.getValue().getLibelle());
		}
	}
	
	public void demmarer(){
		int choix;
		do {
			this.afficher();
			choix = ihmTools.getScanner().nextInt();
			OptionMenu action = actions.get(choix);
			if(action != null){
				action.execute(ihmTools);
			}
		} while(choix != 99);
	}

}
