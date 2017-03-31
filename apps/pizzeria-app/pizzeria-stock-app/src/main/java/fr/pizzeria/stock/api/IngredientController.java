package fr.pizzeria.stock.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Ingredient;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
	
	@Autowired
	Dao<Ingredient, Integer> ingredientDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listIngredients() {
		ModelAndView mav = new ModelAndView();
		List<Ingredient> ingredients = new ArrayList<>();
		try {
			ingredients = ingredientDao.findAll();
		} catch (DaoException e) {
		}
		mav.addObject("ingredients",ingredients);
		mav.setViewName("ingredients/listeIngredients");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ModelAndView formIngredient(@PathVariable int id) {
		ModelAndView mav = new ModelAndView();
		Ingredient ingredient = null;
		try {
			ingredient = ingredientDao.get(id);
		} catch (DaoException e) {
		}
		mav.addObject("ingredient",ingredient);
		mav.setViewName("ingredients/formIngredient");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String updateIngredient(@ModelAttribute Ingredient ingredient) {
		try {
			ingredientDao.update(ingredient.getId(), ingredient);
		} catch (DaoException e) {
		}
		return "redirect:/mvc/ingredients";
	}

}
