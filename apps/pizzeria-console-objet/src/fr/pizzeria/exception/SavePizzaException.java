package fr.pizzeria.exception;

public class SavePizzaException extends Exception {

	public SavePizzaException(Throwable cause) {
		super("Erreur sur la sauvegarde de la pizza.", cause);
	}

}
