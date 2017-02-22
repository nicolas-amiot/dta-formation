package fr.pizzeria.ihm;

public abstract class OptionMenu {
	
	private int id;
	private String libelle;

	public OptionMenu(int id, String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
	public abstract boolean execute();

}
