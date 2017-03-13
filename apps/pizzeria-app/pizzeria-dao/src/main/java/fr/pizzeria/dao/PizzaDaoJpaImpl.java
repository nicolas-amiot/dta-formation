package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

public class PizzaDaoJpaImpl implements Dao<Pizza, String> {

	EntityManagerFactory emf;

	public PizzaDaoJpaImpl() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		emf = Persistence.createEntityManagerFactory("nicolas-pizzeria-console");
	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findAllPizzas", Pizza.class); // TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		em.close();
		return pizzas;
	}

	@Override
	public void save(Pizza pizza) throws DaoException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pizza);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(String code, Pizza pizza) throws DaoException {
		EntityManager em = emf.createEntityManager();
		pizza.setId(getByCode(code, em).getId());
		em.getTransaction().begin();
		em.merge(pizza);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(String code) throws DaoException {
		EntityManager em = emf.createEntityManager();
		Pizza pizza = getByCode(code, em);
		em.getTransaction().begin();
		em.remove(pizza);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void importData(Dao<Pizza, String> source) throws DaoException {
		Logger logger = Logger.getLogger(this.getClass().getName());
		EntityManager em = emf.createEntityManager();
		List<List<Pizza>> listPizzas = ListUtils.partition(source.findAllPizzas(), 3);
		for (List<Pizza> pizzas : listPizzas) {
			em.getTransaction().begin();
			for (Pizza pizza : pizzas) {
				try {
					em.persist(pizza);
					logger.log(Level.INFO, "L'import de la pizza " + pizza.getNom() + " a reussi\n");
				} catch (Exception e) {
					em.getTransaction().rollback();
					em.getTransaction().begin();
					logger.log(Level.WARNING, pizza.getNom() + " n'as pas pu etre synchronise avec la base de donnees\n", e);
				}
			}
			em.getTransaction().commit();
		}
		em.close();
	}

	private Pizza getByCode(String code, EntityManager em) {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.getById", Pizza.class); // TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code = :code", Pizza.class);
		query.setParameter("code", code);
		Pizza pizza = query.getSingleResult();
		return pizza;
	}

}
