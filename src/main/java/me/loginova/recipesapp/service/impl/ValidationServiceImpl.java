package me.loginova.recipesapp.service.impl;

import me.loginova.recipesapp.model.Ingredient;
import me.loginova.recipesapp.model.Recipe;
import me.loginova.recipesapp.service.ValidationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Recipe recipe) {
        return recipe!=null
                && recipe.getName() !=null
                && recipe.getSteps() !=null
                && recipe.getIngredients() != null
                && !recipe.getIngredients().isEmpty()
                && !recipe.getSteps().isEmpty();
    }

    @Override
    public boolean validate(Ingredient ingredient) {
        return ingredient != null
                && ingredient.getName() != null;
    }
}
