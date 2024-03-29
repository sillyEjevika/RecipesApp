package me.loginova.recipesapp.service;

import me.loginova.recipesapp.model.Ingredient;
import me.loginova.recipesapp.model.Recipe;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public interface RecipeService {
    Recipe save(Recipe recipe);

    Optional<Recipe> getById(Long id);

    Recipe update(Long id, Recipe recipe);

    Recipe delete(Long id);

    Map<Long, Recipe> getAll();

    File readFile();

    void uploadFile(MultipartFile file) throws IOException;

    File prepareRecipesTxt() throws IOException;
}

