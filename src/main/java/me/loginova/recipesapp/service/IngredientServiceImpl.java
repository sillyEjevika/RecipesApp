package me.loginova.recipesapp.service;

import me.loginova.recipesapp.exception.ValidationException;
import me.loginova.recipesapp.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class IngredientServiceImpl implements IngredientService {
    private static long idCounter = 1;
    private final Map<Long, Ingredient> ingredients = new HashMap<>();
    private final ValidationServiceImpl validationService;

    public IngredientServiceImpl(ValidationServiceImpl validationService) {
        this.validationService = validationService;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        return ingredients.put(idCounter++, ingredient);
    }

    @Override
    public Optional<Ingredient> getById(Long id) {
        return Optional.ofNullable(ingredients.get(id));
    }
}
