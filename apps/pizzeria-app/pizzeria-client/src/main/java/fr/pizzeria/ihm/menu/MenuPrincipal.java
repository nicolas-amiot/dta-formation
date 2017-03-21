package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.ihm.option.CommanderPizzaOptionMenu;
import fr.pizzeria.ihm.option.ConnexionOptionMenu;
import fr.pizzeria.ihm.option.InscriptionOptionMenu;
import fr.pizzeria.ihm.option.ListerCommandeOptionMenu;
import fr.pizzeria.ihm.option.OptionMenu;
import fr.pizzeria.ihm.option.SortirOptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class MenuPrincipal extends Menu {
	
	private static Map<Integer, OptionMenu> actions = new TreeMap<>();
	{
		actions.put(1, new InscriptionOptionMenu());
		actions.put(2, new ConnexionOptionMenu());
		actions.put(99, new SortirOptionMenu());
	}

	public MenuPrincipal(IhmTools ihmTools) {
		super(ihmTools, "***** Pizzeria Client *****", actions);
	}
	
	public static void MenuClient(){
		actions.clear();
		actions.put(1, new CommanderPizzaOptionMenu());
		actions.put(2, new ListerCommandeOptionMenu());
		actions.put(99, new SortirOptionMenu());
	}

}
