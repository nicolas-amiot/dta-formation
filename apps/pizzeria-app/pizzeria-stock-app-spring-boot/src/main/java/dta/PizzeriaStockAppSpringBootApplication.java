package dta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.IngredientDaoSpringJpaImpl;
import fr.pizzeria.modele.Ingredient;

@SpringBootApplication
@EntityScan("fr.pizzeria.modele")
@EnableJpaRepositories("fr.pizzeria.repos")
public class PizzeriaStockAppSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaStockAppSpringBootApplication.class, args);
	}
	
	@Bean
	public Dao<Ingredient, Integer> ingredientDao() {
		return new IngredientDaoSpringJpaImpl();
	}
}
