package fr.pizzeria.admin.event;

import java.time.ZonedDateTime;

import fr.pizzeria.modele.Pizza;

public class PizzaEvent {
	
	private Pizza pizza;
	private String methode;
	private ZonedDateTime dateCreation;

	public PizzaEvent(Pizza pizza, String methode) {
		this.pizza = pizza;
		this.methode = methode;
		this.dateCreation = ZonedDateTime.now();
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public String getMethode() {
		return methode;
	}

	public void setMethode(String methode) {
		this.methode = methode;
	}

	public ZonedDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(ZonedDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

}
