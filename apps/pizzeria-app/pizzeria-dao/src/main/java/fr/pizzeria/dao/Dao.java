package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.*;

public interface Dao<T, E> {
	
	List<T> findAllPizzas() throws DaoException;
	void save(T element) throws DaoException;
	void update(E code, T element) throws DaoException;
	void delete(E code) throws DaoException;
	default void importData(Dao<T, E> source) throws DaoException{
		System.out.println("Aucun import possible avec cette implémentation");
	}

}
