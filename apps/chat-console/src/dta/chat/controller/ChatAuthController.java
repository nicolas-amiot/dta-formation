package dta.chat.controller;

/**
 * 
 * Strategy interface.
 * 
 */
@FunctionalInterface
public interface ChatAuthController {
	void authenticate(String login);
}