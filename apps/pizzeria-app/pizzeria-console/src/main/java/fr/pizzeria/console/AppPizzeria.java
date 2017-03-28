package fr.pizzeria.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.ihm.menu.Menu;

public class AppPizzeria {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class);
		Menu menu = context.getBean(Menu.class);
		menu.demmarer();
	}

}
