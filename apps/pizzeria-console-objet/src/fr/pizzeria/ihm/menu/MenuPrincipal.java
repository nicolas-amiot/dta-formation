package fr.pizzeria.ihm.menu;

import fr.pizzeria.ihm.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.option.ListerPizzasMenuOption;
import fr.pizzeria.ihm.option.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.option.OptionMenu;
import fr.pizzeria.ihm.option.SortirOptionMenu;
import fr.pizzeria.ihm.option.SupprimerPizzaOptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class MenuPrincipal extends Menu {

	public MenuPrincipal(IhmTools ihmTools) {
		super(ihmTools, "***** Pizzeria Administration *****", new OptionMenu[] {
				new ListerPizzasMenuOption(),
				new AjouterPizzaOptionMenu(),
				new ModifierPizzaOptionMenu(),
				new SupprimerPizzaOptionMenu(),
				new SortirOptionMenu()
				});
	}

}
