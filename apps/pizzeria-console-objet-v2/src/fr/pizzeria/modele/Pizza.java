package fr.pizzeria.modele;

import java.lang.reflect.Field;

public class Pizza {
	
	private int id;
	@ToString
	private String code;
	@ToString
	private String nom;
	@ToString
	private CategoriePizza categorie;
	@ToString
	private double prix;
	public static int nbPizzas = 0;
	
	public Pizza(int id, String code, String nom, double prix, CategoriePizza categorie) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
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
	
	public CategoriePizza getCategorie(){
		return categorie;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Field champ : this.getClass().getDeclaredFields()){
			ToString annotation = champ.getAnnotation(ToString.class);
			if(annotation != null){
				try {
					if(champ.getName().equals("categorie")){
						sb.append("[");
					} else if(champ.getName().equals("prix")){
						sb.append("(");
					}
					sb.append(champ.get(this));
					if(champ.getName().equals("code")){
						sb.append(" -> ");
					} else if (champ.getName().equals("nom")){
						sb.append(" ");
					} else if(champ.getName().equals("categorie")){
						sb.append("] ");
					} else if(champ.getName().equals("prix")){
						sb.append(" €)");
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
}
