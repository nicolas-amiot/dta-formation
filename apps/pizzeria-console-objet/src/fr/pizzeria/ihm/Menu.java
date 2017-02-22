package fr.pizzeria.ihm;

public class Menu {
	
	private String titre;
	private OptionMenu[] actions;
	
	public Menu(String titre, OptionMenu[] actions) {
		this.titre = titre;
		this.actions = actions;
	}

	public void afficher() {
		System.out.println(titre);
		for(OptionMenu optionMenu : actions){
			System.out.println(optionMenu.getLibelle());
		}
	}

}
