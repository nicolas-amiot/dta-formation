package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.ihm.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.option.ListerPizzasMenuOption;
import fr.pizzeria.ihm.option.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.option.OptionMenu;
import fr.pizzeria.ihm.option.SortirOptionMenu;
import fr.pizzeria.ihm.option.SupprimerPizzaOptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class MenuPrincipal extends Menu {
	
	private static Map<Integer, OptionMenu> actions = new TreeMap<>();
	{
		actions.put(1, new ListerPizzasMenuOption());
		actions.put(2, new AjouterPizzaOptionMenu());
		actions.put(3, new ModifierPizzaOptionMenu());
		actions.put(4, new SupprimerPizzaOptionMenu());
		actions.put(99, new SortirOptionMenu());
	}

	public MenuPrincipal(IhmTools ihmTools) {
		super(ihmTools, "***** Pizzeria Administration *****", actions);
	}

}
