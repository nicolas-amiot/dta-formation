package fr.pizzeria.modele;

public class Pizza {
	
	private int id;
	private String code;
	private String nom;
	private double prix;
	public static int nbPizzas = 0;
	
	public Pizza(int id, String code, String nom, double prix) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}
	
}
