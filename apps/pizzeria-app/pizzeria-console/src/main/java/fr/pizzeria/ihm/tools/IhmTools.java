package fr.pizzeria.ihm.tools;

import java.util.ResourceBundle;
import java.util.Scanner;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.*;
import fr.pizzeria.modele.Pizza;

public class IhmTools {
	
	private Dao<Pizza, String> pizzaDao;
	private Scanner scanner = new Scanner(System.in);
	
	public Dao<Pizza, String> getPizzaDao() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String serviceImpl = bundle.getString("service.impl");
		try {
			pizzaDao = (Dao<Pizza, String>) Class.forName(serviceImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(!(pizzaDao instanceof PizzaDaoBddImpl)){
			System.out.println("Attention: l'implémentation choisie n'est pas celle en base de données");
		}
		return pizzaDao;
	}
	
	public Scanner getScanner() {
		return scanner;
	}
	
	public void close(){
		scanner.close();
	}

}
