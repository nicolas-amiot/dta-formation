package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.ClientDaoJpaImpl;
import fr.pizzeria.dao.CommandeDaoJpaImpl;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.LivreurDaoJpaImpl;
import fr.pizzeria.dao.PizzaDaoJpaImpl;
import fr.pizzeria.modele.Client;
import fr.pizzeria.modele.Commande;
import fr.pizzeria.modele.Livreur;
import fr.pizzeria.modele.Pizza;

public class IhmTools {
	
	private Dao<Pizza, String> pizzaDao = new PizzaDaoJpaImpl();
	private Dao<Client, String> clientDao = new ClientDaoJpaImpl();
	private Dao<Livreur, String> livreurDao = new LivreurDaoJpaImpl();
	private Dao<Commande, String> commandeDao = new CommandeDaoJpaImpl();
	
	private Client client;
	
	private Scanner scanner = new Scanner(System.in);
	
	public Dao<Pizza, String> getPizzaDao() {
		return pizzaDao;
	}

	public Dao<Client, String> getClientDao() {
		return clientDao;
	}

	public Dao<Livreur, String> getLivreurDao() {
		return livreurDao;
	}

	public Dao<Commande, String> getCommandeDao() {
		return commandeDao;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void close(){
		scanner.close();
	}

}
