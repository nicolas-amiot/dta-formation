package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.SelectDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class PizzaDaoFichierImpl implements Dao<Pizza, String> {

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		try(Stream<Path> files = Files.list(Paths.get("data"))){
			return files.map(chemin -> {
				String code = chemin.getFileName().toFile().getName().replaceFirst(".txt", "");
				try{
					Charset cs = Charset.forName("Cp1252"); // "Cp1252" is Windows ANSI
					String[] contenuFichier = Files.lines(chemin, cs).findFirst().get().split(";");
					String nom = contenuFichier[0];
					Double prix = Double.valueOf(contenuFichier[1]);
					CategoriePizza categorie = CategoriePizza.valueOf(contenuFichier[2]);
					return new Pizza(code, nom, prix, categorie);
				} catch (IOException e) {
					System.out.println(e.getMessage());
					return null;
				}
			}).collect(Collectors.toList());
		} catch(IOException e){
			throw new SelectDaoException(e.getMessage());
		}
	}

	@Override
	public void save(Pizza pizza) throws DaoException {
		try {
			Files.write(Paths.get("data", pizza.getCode()+".txt"), pizza.toFileString().getBytes(), StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			throw new SaveDaoException(e.getMessage());
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws DaoException {
		try {
			delete(codePizza);
			save(pizza);
		} catch (DaoException e) {
			throw new UpdateDaoException(e.getMessage());
		}
	}

	@Override
	public void delete(String codePizza) throws DaoException {
		try {
			Files.delete(Paths.get("data", codePizza + ".txt"));
		} catch (IOException e) {
			throw new DeleteDaoException(e.getMessage());
		}
	}

}
