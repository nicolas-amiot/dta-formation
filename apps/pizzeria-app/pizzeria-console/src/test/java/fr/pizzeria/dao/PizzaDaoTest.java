package fr.pizzeria.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.console.PizzeriaAppSpringConfig;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PizzeriaAppSpringConfig.class)
public class PizzaDaoTest {
	
	@Autowired
	@Qualifier("pizzaDao")
	private Dao<Pizza, String> pizzaDao;
	
	@Ignore
	@Test
	public void testFindAll(){
		List<Pizza> pizzas = null;
		try {
			pizzas = pizzaDao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		assertTrue(pizzas != null);
	}
	
	@Ignore
	@Test
	public void testUpdate(){
		Pizza pizza = null;
		try {
			pizzaDao.save(new Pizza("TEST", "Test 1", 8.90, CategoriePizza.SANS_VIANDE));
			pizzaDao.update("TEST", new Pizza("TEST", "Test 2", 8.90, CategoriePizza.SANS_VIANDE));
			pizza = pizzaDao.get("TEST");
			pizzaDao.delete("TEST");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		assertTrue(pizza != null && "Pizza test 2".equals(pizza.getNom()));
	}
	
	@Ignore
	@Test
	public void testAOP(){
		Pizza pizza = null;
		try {
			pizzaDao.save(new Pizza(null, "Test 1", 8.90, CategoriePizza.SANS_VIANDE));
			pizzaDao.update("TES", new Pizza(null, "Test 2", 8.90, CategoriePizza.SANS_VIANDE));
			pizza = pizzaDao.get("TES");
			pizzaDao.delete("TEST");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		assertTrue(pizza != null);
	}
	
}
