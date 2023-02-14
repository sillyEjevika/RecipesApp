package me.loginova.recipesapp.exception;

import me.loginova.recipesapp.service.ValidationServiceImpl;

public class ValidationException extends RuntimeException{
    public ValidationException(String entity) {
        super("Ошибка валидации сущности: " + entity);
    }
}
