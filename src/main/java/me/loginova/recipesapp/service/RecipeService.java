package me.loginova.recipesapp.service;

import me.loginova.recipesapp.model.Ingredient;
import me.loginova.recipesapp.model.Recipe;

import java.util.Map;
import java.util.Optional;

public interface RecipeService {
    Recipe save(Recipe recipe);

    Optional<Recipe> getById(Long id);

    Recipe update(Long id, Recipe recipe);

    Recipe delete(Long id);

    Map<Long, Recipe> getAll();
}

