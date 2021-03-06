package fr.pizzeria.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
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
	
	@Ignore
	@Test
	public void testFindAll(){ // Convention normal
		fail("echec");
	}
	
	@Ignore
	@Test
	public void test_find_all() throws DaoException{ // Plus simple à lire lors des tests
		List<Pizza> pizzas = pizzaDao.findAll();
		assertEquals(8, pizzas.size());
	}
	
	@Ignore
	@Test(expected = DaoException.class)
	public void test_save_invalid_data() throws DaoException{
		Pizza pizza = new Pizza(null, null, 0, null);
		pizzaDao.save(pizza);
		List<Pizza> pizzas = pizzaDao.findAll();
		assertEquals(8, pizzas.size());
	}
	
	@Ignore
	@Test
	public void test_save_valid_data() throws DaoException{
		Pizza pizza = new Pizza("TEST", "Test", 10.50, CategoriePizza.SANS_VIANDE);
		pizzaDao.save(pizza);
		List<Pizza> pizzas = pizzaDao.findAll();
		assertThat(pizzas.size(), allOf(is(9), is(10))); // Privilégier asserThat que assertEquals
	}
	
	@Test
	public void test_equals() throws DaoException{
		Pizza p1 = new Pizza("TEST", "Test", 10.50, CategoriePizza.SANS_VIANDE);
		Pizza p2 = new Pizza("TEST", "Test", 9.50, CategoriePizza.SANS_VIANDE);
		Pizza p3 = new Pizza("TEST", "Test2", 10.50, CategoriePizza.SANS_VIANDE);
		assertTrue(p1.equals(p2));
		assertTrue(!p1.equals(p3));
	}

}