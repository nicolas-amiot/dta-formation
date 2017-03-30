package fr.pizzeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.modele.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, String> {

}
