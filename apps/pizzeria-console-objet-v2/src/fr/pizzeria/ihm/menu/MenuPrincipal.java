package fr.pizzeria.ihm.menu;

import java.util.HashMap;

import fr.pizzeria.ihm.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.option.ListerPizzasMenuOption;
import fr.pizzeria.ihm.option.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.option.OptionMenu;
import fr.pizzeria.ihm.option.SortirOptionMenu;
import fr.pizzeria.ihm.option.SupprimerPizzaOptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class MenuPrincipal extends Menu {

	public MenuPrincipal(IhmTools ihmTools) {
		super(ihmTools, "***** Pizzeria Administration *****", new HashMap<Integer, OptionMenu>() {
			{put(1, new ListerPizzasMenuOption());}
			{put(2, new AjouterPizzaOptionMenu());}
			{put(3, new ModifierPizzaOptionMenu());}
			{put(4, new SupprimerPizzaOptionMenu());}
			{put(99, new SortirOptionMenu());}
		});
	}

}
