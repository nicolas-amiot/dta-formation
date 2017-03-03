package fr.pizzeria.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class PizzaDaoImplTest {
	
	private PizzaDaoImpl pizzaDao;
	
	@Before
	public void setUp(){
		pizzaDao = new PizzaDaoImpl();
	}
	
	@Test
	public void testFindAll(){ // Convention normal
		fail("echec");
	}
	
	@Test
	public void test_find_all(){ // Plus simple à lire lors des tests
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		assertEquals(8, pizzas.size());
	}
	
	@Test(expected = DaoException.class)
	public void test_save_invalid_data() throws DaoException{
		Pizza pizza = new Pizza(null, null, 0, null);
		pizzaDao.save(pizza);
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		assertEquals(8, pizzas.size());
	}
	
	@Test
	public void test_save_valid_data() throws DaoException{
		Pizza pizza = new Pizza("TEST", "Test", 10.50, CategoriePizza.SANS_VIANDE);
		pizzaDao.save(pizza);
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		assertThat(pizzas.size(), allOf(is(9), is(10))); // Privilegier asserThat que assertEquals
	}

}
