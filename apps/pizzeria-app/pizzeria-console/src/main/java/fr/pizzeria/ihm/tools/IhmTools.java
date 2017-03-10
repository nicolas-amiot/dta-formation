package fr.pizzeria.ihm.tools;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Pizza;

public class IhmTools {
	
	private Dao<Pizza, String> pizzaDao;
	private Dao<Pizza, String> sourceDao;
	private Scanner scanner = new Scanner(System.in);
	
	public IhmTools() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String serviceImpl = bundle.getString("service.impl");
		String sourceImpl = bundle.getString("service.source");
		try {
			pizzaDao = (Dao<Pizza, String>) Class.forName(serviceImpl).newInstance();
			if(!sourceImpl.isEmpty()){
				sourceDao = (Dao<Pizza, String>) Class.forName(sourceImpl).newInstance();
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
	public Dao<Pizza, String> getPizzaDao() {
		return pizzaDao;
	}
	
	public Dao<Pizza, String> getSourceDao() {
		return sourceDao;
	}
	
	public Scanner getScanner() {
		return scanner;
	}
	
	public void close(){
		scanner.close();
	}

}
