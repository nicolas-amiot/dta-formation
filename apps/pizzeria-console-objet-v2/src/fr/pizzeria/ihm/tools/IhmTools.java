package fr.pizzeria.ihm.tools;

import java.util.Scanner;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.modele.Pizza;

public class IhmTools {
	
	private Dao<Pizza, Integer> pizzaDao = new PizzaDaoImpl();
	private Scanner scanner = new Scanner(System.in);
	
	public Dao<Pizza, Integer> getPizzaDao() {
		return pizzaDao;
	}
	
	public Scanner getScanner() {
		return scanner;
	}
	
	public void close(){
		scanner.close();
	}

}
