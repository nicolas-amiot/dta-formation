package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoJpaImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao<Pizza, String> pizzaDao = new PizzaDaoJpaImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Pizza> pizzas = pizzaDao.findAll();
			request.setAttribute("pizzas", pizzas);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp").forward(request, response);
		} catch (DaoException e) {
			response.setStatus(400);
			response.sendRedirect(request.getContextPath()+"/pizzas/list");
		}
	}

}
