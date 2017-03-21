package fr.pizzeria.ihm.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Commande;

public class ListerCommandeOptionMenu extends OptionMenu {

	public ListerCommandeOptionMenu() {
		super("Lister ses commandes");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		try {
			for(Commande commande : ihmTools.getCommandeDao().findAll()){
				if(commande.getClient().getId() == ihmTools.getClient().getId()){
					System.out.println(commande.getDateCommande() + "n° " + commande.getNumero());
				}
			}
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
