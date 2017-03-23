package fr.pizzeria.admin.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/pizzas/*","/technique"})
public class ConnexionFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if (session.getAttribute("connected") != null && ((boolean) session.getAttribute("connected")) == true) {
			chain.doFilter(request, response);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/authentification.jsp").forward(request, response);
		}
	}

	public void destroy() {

	}

}
