package fr.pizzeria.ihm.option;

import fr.pizzeria.ihm.tools.IhmTools;

public abstract class OptionMenu {
	
	private int id;

	private String libelle;

	public int getId() {
		return id;
	}
	
	public OptionMenu(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
	public abstract boolean execute(IhmTools ihmTools);

}
