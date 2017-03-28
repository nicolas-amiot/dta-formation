package fr.pizzeria.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.ihm.menu.Menu;

public class AppPizzeria {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		Menu menu = context.getBean(Menu.class);
		menu.afficher();
		menu.demmarer();
	}

}
