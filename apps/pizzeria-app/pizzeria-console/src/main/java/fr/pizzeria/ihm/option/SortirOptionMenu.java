package fr.pizzeria.ihm.option;


public class SortirOptionMenu extends OptionMenu {

	public SortirOptionMenu() {
		super("Sortir");
	}

	@Override
	public boolean execute() {
		System.out.println("Fin du programme.");
		return true;
	}

	

}
