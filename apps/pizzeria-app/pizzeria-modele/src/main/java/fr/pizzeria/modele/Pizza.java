package fr.pizzeria.modele;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@NamedQueries({
	@NamedQuery(name = "pizza.findAllPizzas", query = "select p from Pizza p"),
	@NamedQuery(name = "pizza.getById", query = "select p from Pizza p where p.code = :code")
})
public class Pizza {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	@ToString
	private String code;
	@ToString
	private String nom;
	@ToString
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;
	@ToString
	private double prix;
	
	public Pizza() {
		
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	public Integer getId() {
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

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public void setPrix(double prix) {
		this.prix = prix;
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
					Logger logger = Logger.getLogger(this.getClass().getName());
					logger.log(Level.SEVERE, e.getMessage(), e);
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
