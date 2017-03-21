package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Commande;

public class CommandeDaoJpaImpl implements Dao<Commande, String>  {
	
	EntityManagerFactory emf;

	public CommandeDaoJpaImpl() {
		emf = Persistence.createEntityManagerFactory("nicolas-pizzeria-console");
	}

	@Override
	public List<Commande> findAll() throws DaoException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Commande> query = em.createQuery("select c from Commande c", Commande.class);
		List<Commande> commandes = query.getResultList();
		em.close();
		return commandes;
	}

	@Override
	public void save(Commande commande) throws DaoException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(commande);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(String numero, Commande commande) throws DaoException {
		EntityManager em = emf.createEntityManager();
		commande.setId(getByNumero(numero, em).getId());
		em.getTransaction().begin();
		em.merge(commande);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(String numero) throws DaoException {
		EntityManager em = emf.createEntityManager();
		Commande commande = getByNumero(numero, em);
		em.getTransaction().begin();
		em.remove(commande);
		em.getTransaction().commit();
		em.close();
	}
	
	private Commande getByNumero(String numero, EntityManager em) {
		TypedQuery<Commande> query = em.createQuery("select c from Commande c where c.numero = :numero", Commande.class);
		query.setParameter("numero", numero);
		Commande commande = query.getSingleResult();
		return commande;
	}

}
