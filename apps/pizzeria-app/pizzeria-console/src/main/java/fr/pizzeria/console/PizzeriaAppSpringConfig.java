package fr.pizzeria.console;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoSpringJdbcImpl;
import fr.pizzeria.jdbc.DaoConfig;
import fr.pizzeria.modele.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
@Import(DaoConfig.class)
public class PizzeriaAppSpringConfig {
	
	@Bean
	@Qualifier("pizzaDao")
	public Dao<Pizza, String> pizzaDao(DataSource dataSource) {
		return new PizzaDaoSpringJdbcImpl(dataSource);
	}

	@Bean
	@Qualifier("sourceDao")
	public Dao<Pizza, String> sourceDao() {
		return new PizzaDaoFichierImpl();
	}
	
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}

}
