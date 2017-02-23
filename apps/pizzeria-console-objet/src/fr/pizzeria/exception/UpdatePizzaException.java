package fr.pizzeria.exception;

public class UpdatePizzaException extends Exception {
	
	public UpdatePizzaException(Throwable cause) {
		super("Erreur sur la modification de la pizza.", cause);
	}

}
