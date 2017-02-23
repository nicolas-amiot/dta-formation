package fr.pizzeria.exception;

public class DeletePizzaException extends Exception {
	
	public DeletePizzaException(Throwable cause) {
		super("Erreur sur la suppression de la pizza.", cause);
	}

}
