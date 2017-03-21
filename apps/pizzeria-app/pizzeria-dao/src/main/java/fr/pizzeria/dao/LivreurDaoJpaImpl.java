package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Livreur;

public class LivreurDaoJpaImpl implements Dao<Livreur, String>  {
	
	EntityManagerFactory emf;

	public LivreurDaoJpaImpl() {
		emf = Persistence.createEntityManagerFactory("nicolas-pizzeria-console");
	}

	@Override
	public List<Livreur> findAll() throws DaoException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Livreur> query = em.createQuery("select l from Livreur l", Livreur.class);
		List<Livreur> livreurs = query.getResultList();
		em.close();
		return livreurs;
	}

	@Override
	public void save(Livreur livreur) throws DaoException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(livreur);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(String code, Livreur element) throws DaoException {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String code) throws DaoException {
		// TODO Auto-generated method stub
	}

}
