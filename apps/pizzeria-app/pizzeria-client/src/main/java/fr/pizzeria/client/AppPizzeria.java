package fr.pizzeria.client;

import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.MenuPrincipal;
import fr.pizzeria.ihm.tools.IhmTools;

public class AppPizzeria {
	
	public static void main(String[] args) {
		IhmTools ihmTools = new IhmTools();
		Menu menu = new MenuPrincipal(ihmTools);
		menu.demmarer();
		ihmTools.close();
	}

}
