package fr.pizzeria.ihm.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Client;

public class InscriptionOptionMenu extends OptionMenu {

	public InscriptionOptionMenu() {
		super("S'inscrire");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		System.out.println("Votre nom:");
		String nom = ihmTools.getScanner().next();
		System.out.println("Votre prenom:");
		String prenom = ihmTools.getScanner().next();
		System.out.println("Votre email:");
		String email = ihmTools.getScanner().next();
		System.out.println("Votre mot de passe:");
		String password = ihmTools.getScanner().next();
		Client client = new Client(nom, prenom, email, DigestUtils.md5Hex(password));
		try {
			ihmTools.getClientDao().save(client);
		} catch (DaoException e) {
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

}
