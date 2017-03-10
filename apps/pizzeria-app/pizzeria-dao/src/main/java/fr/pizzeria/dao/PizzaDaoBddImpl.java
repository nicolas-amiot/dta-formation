package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.SelectDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.jdbc.ServiceJDBC;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class PizzaDaoBddImpl implements Dao<Pizza, String> {

	private ServiceJDBC jdbc = new ServiceJDBC();

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		Connection cnx = jdbc.connect();
		List<Pizza> pizzas = new ArrayList<>();
		try (PreparedStatement st = cnx.prepareStatement("SELECT * FROM pizza"); ResultSet rs = st.executeQuery()) {
			while (rs.next()) {
				String code = rs.getString("code");
				String nom = rs.getString("nom");
				double prix = rs.getDouble("prix");
				CategoriePizza categorie = CategoriePizza.valueOf(rs.getString("categorie"));
				pizzas.add(new Pizza(code, nom, prix, categorie));
			}
		} catch (SQLException e) {
			throw new SelectDaoException(e.getMessage(), e);
		}
		jdbc.disconnect();
		return pizzas;
	}

	@Override
	public void save(Pizza pizza) throws DaoException {
		Connection cnx = jdbc.connect();
		save(pizza, cnx);
		jdbc.disconnect();
	}

	private void save(Pizza pizza, Connection cnx) throws DaoException {
		try (PreparedStatement st = cnx
				.prepareStatement("INSERT INTO pizza (code, nom, prix, categorie) VALUES (?, ?, ?, ?)")) {
			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getNom());
			st.setDouble(3, pizza.getPrix());
			st.setString(4, pizza.getCategorie().toString());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new SaveDaoException(e.getMessage(), e);
		}
	}

	@Override
	public void update(String code, Pizza pizza) throws DaoException {
		Connection cnx = jdbc.connect();
		try (PreparedStatement st = cnx
				.prepareStatement("UPDATE pizza SET code = ?, nom = ?, prix = ?, categorie = ? WHERE code = ?")) {
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
		Connection cnx = jdbc.connect();
		try (PreparedStatement st = cnx.prepareStatement("DELETE FROM pizza WHERE code = ?")) {
			st.setString(1, code);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteDaoException(e.getMessage(), e);
		}
		jdbc.disconnect();
	}
	
	@Override
	public void importData(Dao<Pizza, String> source) throws DaoException {
		Logger logger = Logger.getLogger(this.getClass().getName());
		Connection cnx = jdbc.connect();
		try {
			cnx.setAutoCommit(false);
			List<List<Pizza>> listPizzas = ListUtils.partition(source.findAllPizzas(), 3);
			for (List<Pizza> pizzas : listPizzas) {
				for (Pizza pizza : pizzas) {
					try {
						save(pizza, cnx);
						logger.log(Level.INFO, "L'import de la pizza " + pizza.getNom() + " a reussi\n");
					} catch (Exception e) {
						logger.log(Level.WARNING, pizza.getNom() + " n'as pas pu etre synchronise avec la base de donnees\n", e);
					}
				}
				cnx.commit();
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		jdbc.disconnect();
	}

}
