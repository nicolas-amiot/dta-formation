package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.pizzeria.exception.DaoException;

public class ServiceJDBC {

	private Connection cnx = null;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public ServiceJDBC(){
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		driver = bundle.getString("database.driver");
		url = "jdbc:"+bundle.getString("database.type")+"://"+bundle.getString("database.host")+":"+bundle.getString("database.port")+"/"+bundle.getString("database.name");
		user = bundle.getString("database.user");
		password = bundle.getString("database.password");
	}

	public Connection connect() throws DaoException {
		try {
			Class.forName(driver);
			cnx = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException(e.getMessage());
		}
		return cnx;
	}

	public void disconnect() throws DaoException {
		try {
			if (cnx != null && !cnx.isClosed()) {
				cnx.close();
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}

}