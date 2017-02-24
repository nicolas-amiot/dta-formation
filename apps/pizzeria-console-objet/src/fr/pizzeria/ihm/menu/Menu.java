package fr.pizzeria.ihm.menu;

import fr.pizzeria.ihm.option.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class Menu {
	
	private String titre;
	private OptionMenu[] actions;
	private IhmTools ihmTools;
	
	public Menu(IhmTools ihmTools, String titre, OptionMenu[] actions) {
		this.ihmTools = ihmTools;
		this.titre = titre;
		this.actions = actions;
	}

	public void afficher() {
		System.out.println(titre);
		for(OptionMenu optionMenu : actions){
			System.out.println(optionMenu.getId() + ". " + optionMenu.getLibelle());
		}
	}
	
	public void demmarer(){
		int choix;
		do {
			this.afficher();
			choix = ihmTools.getScanner().nextInt();
			for(OptionMenu optionMenu : actions){
				if(choix == optionMenu.getId()){
					optionMenu.execute(ihmTools);
				}
			}
		} while(choix != actions[4].getId());
	}

}
