package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;
import fr.pizzeria.repos.PizzaRepository;

@Repository
@Transactional
public class PizzaDaoSpringJpaImpl implements Dao<Pizza, String> {
	
	/* If you don't use the interface who extend JpaRepository */
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PizzaRepository pizzaRepository;

	public List<Pizza> findAll() throws DaoException {
		return pizzaRepository.findAll();
	}

	public void save(Pizza pizza) throws DaoException {
		pizzaRepository.save(pizza);
	}

	public void update(String code, Pizza pizza) throws DaoException {
		pizza.setId(get(code).getId());
		pizzaRepository.save(pizza);
	}

	public void delete(String code) throws DaoException {
		pizzaRepository.delete(code);
	}
	
	public Pizza get(String code) throws DaoException {
		return pizzaRepository.findOne(code);
	}

}
