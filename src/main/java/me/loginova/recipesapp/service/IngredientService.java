package me.loginova.recipesapp.service;

import me.loginova.recipesapp.model.Ingredient;

import java.util.Optional;

public interface IngredientService {
    Ingredient save(Ingredient ingredient);

    Optional<Ingredient> getById(Long id);
}
