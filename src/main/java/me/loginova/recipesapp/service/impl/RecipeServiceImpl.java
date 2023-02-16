package me.loginova.recipesapp.service.impl;

import me.loginova.recipesapp.exception.ValidationException;
import me.loginova.recipesapp.model.Recipe;
import me.loginova.recipesapp.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static long idCounter = 1;
    private final Map<Long, Recipe> recipes = new HashMap<>();
    private final ValidationServiceImpl validationService;
    public RecipeServiceImpl(ValidationServiceImpl validationService) {
        this.validationService = validationService;
    }

    @Override
    public Recipe save(Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        recipes.put(idCounter++, recipe);
        return recipe;
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return Optional.ofNullable(recipes.get(id));
    }

    @Override
    public Recipe update(Long id, Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        return recipes.replace(id, recipe);
    }

    @Override
    public Recipe delete(Long id) {
        return recipes.remove(id);
    }

    @Override
    public Map<Long, Recipe> getAll() {
        return recipes;
    }
}
