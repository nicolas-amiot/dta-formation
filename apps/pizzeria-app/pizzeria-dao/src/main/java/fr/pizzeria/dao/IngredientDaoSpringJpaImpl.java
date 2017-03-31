package fr.pizzeria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Ingredient;
import fr.pizzeria.repos.IngredientRepository;

@Repository
@Transactional
public class IngredientDaoSpringJpaImpl implements Dao<Ingredient, Integer> {
	
	@Autowired
	private IngredientRepository ingredientRepository;

	public List<Ingredient> findAll() throws DaoException {
		return ingredientRepository.findAll();
	}

	public void save(Ingredient ingredient) throws DaoException {
		ingredientRepository.save(ingredient);
	}

	public void update(Integer id, Ingredient ingredient) throws DaoException {
		ingredient.setId(id);
		ingredientRepository.save(ingredient);
	}

	public void delete(Integer id) throws DaoException {
		ingredientRepository.delete(id);
	}
	
	public Ingredient get(Integer id) throws DaoException {
		return ingredientRepository.findOne(id);
	}

}
