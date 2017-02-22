package fr.pizzeria.ihm;

import java.util.Scanner;

public class SortirOptionMenu extends OptionMenu {

	public SortirOptionMenu() {
		super(99, "Sortir");
	}

	@Override
	public boolean execute(Scanner sc) {
		System.out.println("Fin du programme.");
		return true;
	}

	

}
