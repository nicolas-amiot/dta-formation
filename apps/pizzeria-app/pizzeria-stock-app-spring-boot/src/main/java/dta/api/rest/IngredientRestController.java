package dta.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Ingredient;

@Controller
@RequestMapping("/rest/ingredients")
public class IngredientRestController {
	
	@Autowired
	Dao<Ingredient, Integer> ingredientDao;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Ingredient> listerIngredients(){
		try {
			return ingredientDao.findAll();
		} catch (DaoException e) {
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void save(@RequestBody Ingredient ingredient) {
		try {
			ingredientDao.save(ingredient);
		} catch (DaoException e) {
		}
	}

}
