package fr.pizzeria.conf;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
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
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException{
	    LocalContainerEntityManagerFactoryBean factory =  new LocalContainerEntityManagerFactoryBean();
	    factory.setPersistenceUnitName("nicolas-pizzeria-console"); /* Optional if you have only one persistence */
	    return factory;
	}
	
	@Bean
	public PlatformTransactionManager txManager(){
		return new JpaTransactionManager();
	}

}
