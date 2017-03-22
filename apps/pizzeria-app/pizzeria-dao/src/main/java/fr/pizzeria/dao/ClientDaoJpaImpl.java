package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Client;

public class ClientDaoJpaImpl implements Dao<Client, String>  {
	
	EntityManagerFactory emf;

	public ClientDaoJpaImpl() {
		emf = Persistence.createEntityManagerFactory("nicolas-pizzeria-console");
	}

	@Override
	public List<Client> findAll() throws DaoException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Client> query = em.createQuery("select c from Client c", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	@Override
	public void save(Client client) throws DaoException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(String email, Client client) throws DaoException {
		EntityManager em = emf.createEntityManager();
		client.setId(get(email, em).getId());
		em.getTransaction().begin();
		em.merge(client);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(String email) throws DaoException {
		EntityManager em = emf.createEntityManager();
		Client client = get(email, em);
		em.getTransaction().begin();
		em.remove(client);
		em.getTransaction().commit();
		em.close();
	}
	
	private Client get(String email, EntityManager em) {
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.email = :email", Client.class);
		query.setParameter("email", email);
		Client client = query.getSingleResult();
		return client;
	}

	@Override
	public Client get(String email) throws DaoException {
		EntityManager em = emf.createEntityManager();
		Client client = get(email, em);
		em.close();
		return client;
	}

}
