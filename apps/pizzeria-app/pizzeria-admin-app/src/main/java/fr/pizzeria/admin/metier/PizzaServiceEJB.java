package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

@Stateless
public class PizzaServiceEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Pizza> findAll() throws DaoException {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findAllPizzas", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		return pizzas;
	}

	public void save(Pizza pizza) throws DaoException {
		em.persist(pizza);
	}

	public void update(String code, Pizza pizza) throws DaoException {
		pizza.setId(get(code).getId());
		em.merge(pizza);
	}

	public void delete(String code) throws DaoException {
		Pizza pizza = get(code);
		em.remove(pizza);
	}
	
	public Pizza get(String code) throws DaoException {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.getByCode", Pizza.class);
		query.setParameter("code", code);
		Pizza pizza = query.getSingleResult();
		return pizza;
	}

}
