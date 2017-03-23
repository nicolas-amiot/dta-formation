package fr.pizzeria.admin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoJpaImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao<Pizza, String> pizzaDao = new PizzaDaoJpaImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Pizza pizza = pizzaDao.get(request.getParameter("code"));
			request.setAttribute("pizza", pizza);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp").forward(request, response);
		} catch (DaoException e) {
			response.setStatus(400);
			response.sendRedirect(request.getContextPath()+"/pizzas/list");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String old_code = request.getParameter("old_code");
			Pizza pizza = new Pizza(request.getParameter("code"), request.getParameter("nom"), Double.parseDouble(request.getParameter("prix")), CategoriePizza.valueOf(request.getParameter("categorie")), request.getParameter("image"));
			pizzaDao.update(old_code, pizza);
			response.sendRedirect(request.getContextPath()+"/pizzas/list");
		} catch (DaoException e) {
			response.setStatus(400);
			response.sendRedirect(request.getContextPath()+"/pizzas/list");
		}
	}

}
