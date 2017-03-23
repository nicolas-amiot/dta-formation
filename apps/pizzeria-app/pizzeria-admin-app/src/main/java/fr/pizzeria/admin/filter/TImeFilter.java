package fr.pizzeria.admin.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.map.HashedMap;

@WebFilter(urlPatterns = "/*")
public class TImeFilter implements Filter {

	private FilterConfig config = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("TimerFilter initialized");
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		long temps = after - before;
		String path = ((HttpServletRequest) request).getRequestURI();
		Map<String, Long> tempsRequetes = (Map<String, Long>) config.getServletContext().getAttribute("tempsRequetes");
		if(tempsRequetes == null){
			tempsRequetes = new HashedMap<>();
		}
		tempsRequetes.put(path, temps);
		config.getServletContext().setAttribute("tempsRequetes", tempsRequetes);
	}

}
