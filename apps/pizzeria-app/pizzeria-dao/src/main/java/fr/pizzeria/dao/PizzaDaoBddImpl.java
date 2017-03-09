package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.SelectDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class PizzaDaoBddImpl implements Dao<Pizza, String> {

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		ServiceJDBC jdbc = new ServiceJDBC();
		Connection cnx = jdbc.connect();
		List<Pizza> pizzas = new ArrayList<>();
		try(PreparedStatement st = cnx.prepareStatement("SELECT * FROM pizza")){
			try(ResultSet rs = st.executeQuery()){
				while(rs.next()){
					String code = rs.getString("code");
					String nom = rs.getString("nom");
					double prix = rs.getDouble("prix");
					CategoriePizza categorie = CategoriePizza.valueOf(rs.getString("categorie"));
					pizzas.add(new Pizza(code, nom, prix, categorie));
				}
			}
		} catch (SQLException e) {
			throw new SelectDaoException(e.getMessage(), e);
		}
		jdbc.disconnect();
		return pizzas;
	}

	@Override
	public void save(Pizza pizza) throws DaoException {
		ServiceJDBC jdbc = new ServiceJDBC();
		Connection cnx = jdbc.connect();
		try(PreparedStatement st = cnx.prepareStatement("INSERT INTO pizza (code, nom, prix, categorie) VALUES (?, ?, ?, ?)")){
			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getNom());
			st.setDouble(3, pizza.getPrix());
			st.setString(4, pizza.getCategorie().toString());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new SaveDaoException(e.getMessage(), e);
		}
		jdbc.disconnect();
	}

	@Override
	public void update(String code, Pizza pizza) throws DaoException {
		ServiceJDBC jdbc = new ServiceJDBC();
		Connection cnx = jdbc.connect();
		try(PreparedStatement st = cnx.prepareStatement("UPDATE pizza SET code = ?, nom = ?, prix = ?, categorie = ? WHERE code = ?")){
			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getNom());
			st.setDouble(3, pizza.getPrix());
			st.setString(4, pizza.getCategorie().toString());
			st.setString(5, code);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new UpdateDaoException(e.getMessage(), e);
		}
		jdbc.disconnect();
	}

	@Override
	public void delete(String code) throws DaoException {
		ServiceJDBC jdbc = new ServiceJDBC();
		Connection cnx = jdbc.connect();
		try(PreparedStatement st = cnx.prepareStatement("DELETE FROM pizza WHERE code = ?")){
			st.setString(1, code);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteDaoException(e.getMessage(), e);
		}
		jdbc.disconnect();
	}

}
