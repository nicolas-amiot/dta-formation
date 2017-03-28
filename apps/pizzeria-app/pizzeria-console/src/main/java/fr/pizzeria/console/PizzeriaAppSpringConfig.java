package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoJpaImpl;
import fr.pizzeria.modele.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig {
	
	@Bean
	@Qualifier("pizzaDao")
	public Dao<Pizza, String> pizzaDao() {
		return new PizzaDaoJpaImpl();
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
