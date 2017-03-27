package fr.pizzeria.admin.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

@Path("/rest/pizzas")
public class PizzaRessource {
	
	@Inject private PizzaService pizzaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> findAll() {
		List<Pizza> pizzas = new ArrayList<>();
		try {
			pizzas = pizzaService.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return pizzas;
	}
	
	@GET
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza get(@PathParam("code") String code) {
		Pizza pizza = null;
		try {
			pizza = pizzaService.get(code);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return pizza;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Pizza pizza) {
		try {
			pizzaService.save(pizza);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("code") String code, Pizza pizza) {
		try {
			pizzaService.update(code, pizza);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Path("/{code}")
	public void delete(@PathParam("code") String code) {
		try {
			pizzaService.delete(code);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
