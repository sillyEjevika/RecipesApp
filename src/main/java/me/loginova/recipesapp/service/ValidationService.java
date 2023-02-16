package me.loginova.recipesapp.service;

import me.loginova.recipesapp.model.Ingredient;
import me.loginova.recipesapp.model.Recipe;

public interface ValidationService {
    public boolean validate(Recipe recipe);

    public boolean validate(Ingredient ingredient);
}
