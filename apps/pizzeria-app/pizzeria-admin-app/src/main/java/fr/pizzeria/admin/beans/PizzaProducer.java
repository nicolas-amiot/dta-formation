package fr.pizzeria.admin.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.admin.event.PizzaEvent;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoJpaImpl;
import fr.pizzeria.modele.Pizza;

public class PizzaProducer {
	
	@Produces
	@ApplicationScoped
	public Dao<Pizza, String> getDao(){
		return  new PizzaDaoJpaImpl();
	}
	
	@Produces
	@ApplicationScoped
	public List<PizzaEvent> getEvents() {
		return new ArrayList<>();
	}

}
