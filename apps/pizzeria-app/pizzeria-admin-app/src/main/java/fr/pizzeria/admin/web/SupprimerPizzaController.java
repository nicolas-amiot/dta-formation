package fr.pizzeria.admin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoJpaImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

public class SupprimerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao<Pizza, String> pizzaDao = new PizzaDaoJpaImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			pizzaDao.delete(request.getParameter("code"));
			response.sendRedirect(request.getContextPath()+"/pizzas/list");
		} catch (DaoException e) {
			response.setStatus(400);
			response.sendRedirect(request.getContextPath()+"/pizzas/list");
		}
	}

}
