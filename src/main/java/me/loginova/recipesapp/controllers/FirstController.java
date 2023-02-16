package me.loginova.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping( "/")
    public String appWork() {
        return "Приложение запущено";
    }
    @GetMapping( "/info")
    public String info() {
        return "Имя ученика: Логинова Виктория Николаевна <br/>" +
                " Проект: Рецепты <br/>" +
                " Дата создания проекта: 02.02.2023 <br/> " +
                "Описание проекта: вкусные рецепты на каждый день";
    }
}
