package fr.pizzeria.modele;

import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pizza {

	@ToString
	private String code;
	@ToString
	private String nom;
	@ToString
	private CategoriePizza categorie;
	@ToString
	private double prix;

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
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

	public CategoriePizza getCategorie() {
		return categorie;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Field champ : this.getClass().getDeclaredFields()) {
			ToString annotation = champ.getAnnotation(ToString.class);
			if (annotation != null) {
				try {
					if ("categorie".equals(champ.getName())) {
						sb.append("[");
					} else if ("prix".equals(champ.getName())) {
						sb.append("(");
					}
					sb.append(champ.get(this));
					if ("code".equals(champ.getName())) {
						sb.append(" -> ");
					} else if ("nom".equals(champ.getName())) {
						sb.append(" ");
					} else if ("categorie".equals(champ.getName())) {
						sb.append("] ");
					} else if ("prix".equals(champ.getName())) {
						sb.append(")");
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	public String toFileString() {
		return this.nom + ";" + this.prix + ";" + this.categorie.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Pizza pizza = (Pizza) obj;
		return new EqualsBuilder().append(code, pizza.getCode()).append(nom, pizza.getNom())
				.append(categorie, pizza.getCategorie()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(code).append(nom).append(categorie).toHashCode();
	}

}
