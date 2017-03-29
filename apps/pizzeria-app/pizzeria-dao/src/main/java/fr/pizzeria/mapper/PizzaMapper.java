package fr.pizzeria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class PizzaMapper implements RowMapper<Pizza> {

	@Override
	public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
		String code = rs.getString("code");
		String nom = rs.getString("nom");
		double prix = rs.getDouble("prix");
		CategoriePizza categorie = CategoriePizza.valueOf(rs.getString("categorie"));
		String url = rs.getString("url");
		return new Pizza(code, nom, prix, categorie, url);
	}

}
