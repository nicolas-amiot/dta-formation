package fr.pizzeria.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.pizzeria.modele.Pizza;

@Component
@Aspect
public class PizzaAspect {
	
	@Before("execution(* fr.pizzeria.dao.*.save(..)) && args(pizza)")
	private void setCodeIfEmpty(Pizza pizza) {
		if(pizza.getCode() == null || pizza.getCode().isEmpty()){
			pizza.setCode(pizza.getNom().substring(0, 3).toUpperCase());
		}
	}
	
	@Before("execution(* fr.pizzeria.dao.*.update(..)) && args(code, pizza)")
	private void setCodeIfRemove(String code, Pizza pizza) {
		if(pizza.getCode() == null || pizza.getCode().isEmpty()){
			pizza.setCode(code);
		}
	}

}
