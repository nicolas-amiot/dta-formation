package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import fr.pizzeria.ihm.option.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import fr.pizzeria.ihm.option.OptionMenu;

@Controller
public class Menu {
	
	private String titre;
	private Map<Integer, OptionMenu> actions;
	private Scanner scanner;
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	public Menu(Scanner scanner) {
		this.titre = "***** Pizzeria Administration *****";
		this.scanner = scanner;
	}
	
	@PostConstruct
	public void init() {
		this.actions = new TreeMap<>();
		this.actions.put(1, context.getBean(ListerPizzasMenuOption.class));
		this.actions.put(2, context.getBean(AjouterPizzaOptionMenu.class));
		this.actions.put(3, context.getBean(ModifierPizzaOptionMenu.class));
		this.actions.put(4, context.getBean(SupprimerPizzaOptionMenu.class));
		this.actions.put(5, context.getBean(ListerPizzasCategorieOptionMenu.class));
		this.actions.put(6, context.getBean(AfficherPizzaUltime.class));
		this.actions.put(7, context.getBean(ImporterPizzaOptionMenu.class));
		this.actions.put(99, context.getBean(SortirOptionMenu.class));
	}

	public void afficher() {
		System.out.println(titre);
		for(Entry<Integer, OptionMenu> entry : actions.entrySet()){
			System.out.println(entry.getKey() + ". " + entry.getValue().getLibelle());
		}
	}
	
	public void demmarer(){
		int choix;
		boolean termine = false;
		do {
			this.afficher();
			choix = scanner.nextInt();
			OptionMenu action = actions.get(choix);
			if(action != null){
				termine = action.execute();
			}
		} while(!termine);
	}

}
