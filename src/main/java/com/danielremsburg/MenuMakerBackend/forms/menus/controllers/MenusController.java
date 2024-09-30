package com.danielremsburg.MenuMakerBackend.forms.menus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielremsburg.MenuMakerBackend.forms.menus.interfaces.Menu;
import com.danielremsburg.MenuMakerBackend.forms.menus.services.MenuService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
public class MenusController {

    private final MenuService menuService;

    public MenusController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{date}")
    public List<Menu> getAllMenusByDate(@PathVariable LocalDate date) {
        return menuService.getAllMenusByDate(date);
    }

    @GetMapping("/{date}/{meal}/{line}")
    public Menu getMenuByDateAndMeal(@PathVariable LocalDate date, @PathVariable String meal, @PathVariable String line) {
        
        return menuService.getMenuByDateAndMealAndLine(date, meal, line);
    }

    @GetMapping("/{date}/{line}")
    public List<Menu> getMenusByDateAndLine(@PathVariable LocalDate date, @PathVariable String line) {
        return menuService.getMenusByDateAndLine(date, line);
    }
}