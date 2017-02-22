package fr.pizzeria.ihm;

import java.util.Scanner;

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
	
	public abstract boolean execute(Scanner sc);

}
