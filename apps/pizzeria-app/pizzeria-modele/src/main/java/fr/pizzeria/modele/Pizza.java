package fr.pizzeria.modele;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
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
	@NamedQuery(name = "pizza.getByCode", query = "select p from Pizza p where p.code = :code")
})
public class Pizza implements Serializable {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Id
	@ToString
	@Column(length = 255, unique = true)
	private String code;
	
	@ToString
	@Column(length = 255)
	private String nom;
	
	@ToString
	private double prix;
	
	@ToString
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;
	
	@Column(length = 255)
	private String url;
	
	public Pizza() {
		
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public Pizza(String code, String nom, double prix, CategoriePizza categorie, String url) {
		this(code, nom, prix, categorie);
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
