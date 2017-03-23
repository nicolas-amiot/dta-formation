package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/technique")
public class Technique extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Long> tempsRequetes = (Map<String, Long>) this.getServletContext().getAttribute("tempsRequetes");
		Integer compteur = (Integer) this.getServletContext().getAttribute("compteur");
		request.setAttribute("tempsRequetes", tempsRequetes);
		request.setAttribute("compteur", compteur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/technique.jsp").forward(request, response);
	}

}
