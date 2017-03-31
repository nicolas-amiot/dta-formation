package fr.pizzeria.stock.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fr.pizzeria.conf.DaoConfig;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.IngredientDaoSpringJpaImpl;
import fr.pizzeria.modele.Ingredient;

@Configuration
@EnableWebMvc
@ComponentScan("fr.pizzeria.stock.api")
@Import(DaoConfig.class)
public class PizzeriaSpringConfig {
	
	@Bean
	public Dao<Ingredient, Integer> ingredientDao() {
		return new IngredientDaoSpringJpaImpl();
	}
	
	@Bean  
    public InternalResourceViewResolver viewResolver() {  
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
        resolver.setPrefix("/WEB-INF/views/");  
        resolver.setSuffix(".jsp");
        return resolver;  
    }

}
