package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoJpaImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

@WebServlet("/api/servlet/pizzas")
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(this.getClass().getName());
	@Inject private PizzaService pizzaService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Pizza> pizzas = pizzaService.findAll();
			for(Pizza pizza : pizzas){
				response.getWriter().append(pizza.toString()+"\n");
			}
		} catch (DaoException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Pizza pizza = new Pizza("TEST", "Servlet", 9.90, CategoriePizza.VIANDE);
			pizzaService.save(pizza);
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
			pizzaService.update("TEST", pizza);
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
			pizzaService.delete("TEST");
			response.getWriter().print("Suppression de la pizza réussi");
		} catch (DaoException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

}
