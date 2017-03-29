package fr.pizzeria.jdbc;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DaoConfig {

	@Bean
	public DataSource dataSource() throws SQLException {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("database.driver");
		String url = "jdbc:" + bundle.getString("database.type") + "://" + bundle.getString("database.host") + ":" + bundle.getString("database.port") + "/" + bundle.getString("database.name");
		String user = bundle.getString("database.user");
		String password = bundle.getString("database.password");
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setUrl(url);
		return ds;
	}

}
