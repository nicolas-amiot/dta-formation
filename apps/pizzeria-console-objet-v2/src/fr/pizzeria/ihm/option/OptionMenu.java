package fr.pizzeria.ihm.option;

import fr.pizzeria.ihm.tools.IhmTools;

public abstract class OptionMenu {

	private String libelle;
	
	public OptionMenu(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
	public abstract boolean execute(IhmTools ihmTools);

}
