package fr.pizzeria.ihm.option;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.MenuPrincipal;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Client;

public class ConnexionOptionMenu extends OptionMenu {

	public ConnexionOptionMenu() {
		super("Se connecter");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		System.out.println("Votre email:");
		String email = ihmTools.getScanner().next();
		System.out.println("Votre mot de passe:");
		String password = ihmTools.getScanner().next();
		try {
			List<Client> clients = ihmTools.getClientDao().findAll();
			for(Client client : clients){
				if(client.getEmail().equals(email)){
					if(client.getPassword().equals(DigestUtils.md5Hex(password))){
						ihmTools.setClient(client);
						MenuPrincipal.MenuClient();
					}
					break;
				}
			}
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
