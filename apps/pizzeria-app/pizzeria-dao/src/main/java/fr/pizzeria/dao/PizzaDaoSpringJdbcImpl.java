package fr.pizzeria.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.mapper.PizzaMapper;
import fr.pizzeria.modele.Pizza;

@Repository
public class PizzaDaoSpringJdbcImpl implements Dao<Pizza, String> {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PizzaDaoSpringJdbcImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Pizza> findAll() throws DaoException {
		String sql = "SELECT * FROM pizza";
		return this.jdbcTemplate.query(sql, new PizzaMapper());
	}

	@Override
	public void save(Pizza pizza) throws DaoException {
		String sql = "INSERT INTO pizza (code, nom, prix, categorie, url) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCategorie().toString(), pizza.getUrl());
	}

	@Override
	public void update(String code, Pizza pizza) throws DaoException {
		String sql = "UPDATE pizza SET code = ?, nom = ?, prix = ?, categorie = ?, url = ? WHERE code = ?";
		jdbcTemplate.update(sql, pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCategorie().toString(), pizza.getUrl(), code);
	}

	@Override
	public void delete(String code) throws DaoException {
		String sql = "DELETE FROM pizza WHERE code = ?";
		jdbcTemplate.update(sql, code);
	}
	
	@Override
	public Pizza get(String code) throws DaoException {
		String sql = "SELECT * FROM pizza WHERE code = ?";
		List<Pizza> pizzas = jdbcTemplate.query(sql, new PizzaMapper(), code);
		if(!pizzas.isEmpty()){
		    return pizzas.get(0);
		}
		return null;
	}

}
