package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoJpaImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(this.getClass().getName());
	private static Dao<Pizza, String> pizzaDao = new PizzaDaoJpaImpl();

    /**
     * Default constructor. 
     */
    public PizzaServletWebApi() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Pizza> pizzas = pizzaDao.findAll();
			for(Pizza pizza : pizzas){
				response.getWriter().append(pizza.toString()+"\n");
			}
		} catch (DaoException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Pizza pizza = new Pizza("TEST", "Servlet", 9.90, CategoriePizza.VIANDE);
			pizzaDao.save(pizza);
			response.getWriter().print("Ajout de la pizza réussi");
		} catch (DaoException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Pizza pizza = new Pizza("TEST2", "Servlet", 9.90, CategoriePizza.VIANDE);
			pizzaDao.update("TEST", pizza);
			response.getWriter().print("Modification de la pizza réussi");
		} catch (DaoException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			pizzaDao.delete("TEST");
			response.getWriter().print("Suppression de la pizza réussi");
		} catch (DaoException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

}
