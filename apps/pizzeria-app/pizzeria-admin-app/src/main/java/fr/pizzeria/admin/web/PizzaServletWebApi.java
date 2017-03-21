package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

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
	private static Dao<Pizza, String> pizzaDao;

    /**
     * Default constructor. 
     */
    public PizzaServletWebApi() {
    	pizzaDao = new PizzaDaoJpaImpl();
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
			response.getWriter().print("Impossible de lister les pizzas");
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
			response.getWriter().print("Impossible de lister les pizzas");
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
			response.getWriter().print("Impossible de modifier la pizza 'TEST'");
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
			response.getWriter().print("Impossible de supprimer la pizza 'TEST'");
		}
	}

}
