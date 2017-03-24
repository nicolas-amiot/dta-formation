package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import fr.pizzeria.admin.event.PizzaEvent;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

public class PizzaService {

	@EJB private PizzaServiceEJB pizzaDao;
	@Inject private Event<PizzaEvent> pizzaEvent;
	@Inject private List<PizzaEvent> events;

	public List<Pizza> findAll() throws DaoException {
		return pizzaDao.findAll();
	}

	public void save(Pizza pizza) throws DaoException {
		pizzaDao.save(pizza);
		pizzaEvent.fire(new PizzaEvent(pizza, "Save"));
	}

	public void update(String code, Pizza pizza) throws DaoException {
		pizzaDao.update(code, pizza);
		pizzaEvent.fire(new PizzaEvent(pizza, "Update"));
	}

	public void delete(String code) throws DaoException {
		Pizza pizza = pizzaDao.get(code);
		pizzaDao.delete(code);
		pizzaEvent.fire(new PizzaEvent(pizza, "Delete"));
	}

	public Pizza get(String code) throws DaoException {
		return pizzaDao.get(code);
	}
	
	public List<PizzaEvent> getEvents() {
		return events;
	}

	public void ecouteSave(@Observes PizzaEvent event) {
		events.add(event);
	}


}
