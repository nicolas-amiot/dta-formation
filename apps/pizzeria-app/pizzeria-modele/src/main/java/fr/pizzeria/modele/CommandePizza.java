package fr.pizzeria.modele;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CommandePizza implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	
	@Id
	@OneToOne
	private Pizza pizza;
	
	public CommandePizza() {
		
	}

	public CommandePizza(Commande commande,  Pizza pizza) {
		this.commande = commande;
		this.pizza = pizza;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
