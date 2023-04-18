package me.loginova.recipesapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.loginova.recipesapp.service.IngredientService;
import me.loginova.recipesapp.service.RecipeService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/files")
@Tag(name = "API для работы с файлами рецептов, ингредиентов", description = "Загрузка/выгрузка файлов рецептов и ингредиентов")
@RequiredArgsConstructor
public class FileController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    @GetMapping("/recipe/export")
    @Operation(
            summary = "Выгрузка файлов рецептов"
    )
    public ResponseEntity<InputStreamResource> downloadRecipesFile() {
        try {
            File recipeFile = recipeService.readFile();
            InputStreamResource resource = new InputStreamResource(new FileInputStream(recipeFile));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(recipeFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + recipeFile.getName())
                    .body(resource);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/recipe/export/txt")
    @Operation(
            summary = "Выгрузка файлов рецептов в формате Txt"
    )
    public ResponseEntity<InputStreamResource> downloadRecipesTxtFile() {
        try {
            File recipeFile = recipeService.prepareRecipesTxt();
            InputStreamResource resource = new InputStreamResource(new FileInputStream(recipeFile));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(recipeFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + recipeFile.getName())
                    .body(resource);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/recipe/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка файлов рецептов"
    )
    public ResponseEntity<String> uploadRecipesFile(@RequestParam MultipartFile file) {
        try {
            recipeService.uploadFile(file);
            return ResponseEntity.ok("Файл успешно загружен");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ошибка при загрузке файла. ПРоверьте корректность файла.");
        }
    }
    @PostMapping(value = "/ingredient/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка файлов ингредиентов"
    )
    public ResponseEntity<String> uploadIngredientFile(@RequestParam MultipartFile file) {
        try {
            ingredientService.uploadFile(file);
            return ResponseEntity.ok("Файл успешно загружен");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ошибка при загрузке файла. ПРоверьте корректность файла.");
        }
    }
}
