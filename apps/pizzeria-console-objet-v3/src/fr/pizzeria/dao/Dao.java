package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.*;

public interface Dao<T, E> {
	
	List<T> findAllPizzas();
	void save(T element) throws DaoException;
	void update(E id, T element) throws DaoException;
	void delete(E id) throws DaoException;

}
