package com.danielremsburg.MenuMakerBackend.forms.menus.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielremsburg.MenuMakerBackend.forms.lines.interfaces.Line;
import com.danielremsburg.MenuMakerBackend.forms.lines.services.LineService;
import com.danielremsburg.MenuMakerBackend.forms.meals.enums.Meal;
import com.danielremsburg.MenuMakerBackend.forms.menus.entitites.MenuEntity;
import com.danielremsburg.MenuMakerBackend.forms.menus.interfaces.Menu;
import com.danielremsburg.MenuMakerBackend.forms.menus.repositories.MenuRepository;

import jakarta.transaction.Transactional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private LineService lineService;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public List<Menu> getAllMenus() {
        return (List<Menu>) menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Transactional
    public Menu getMenu(LocalDate date, Meal meal, Line lineEntity) {
        Optional<Menu> existingMenu = menuRepository.findByDateAndMealAndLine(date, meal, lineEntity);
        return existingMenu.orElseGet(() -> {
            Menu newMenu = new MenuEntity(date, meal, lineEntity);
            return menuRepository.save(newMenu);
        });
    }
  public Menu getMenu(LocalDate date, String meal, String line) {
   Meal mealEnum = Meal.valueOf(meal.toUpperCase());
   Line lineEntity = lineService.getLineByName(line);
   return getMenu(date, mealEnum, lineEntity);
  }
    public List<Menu> getAllMenusByDate(LocalDate date) {
      return menuRepository.getAllMenusByDate(date);
    }

    public List<Menu> getMenusByDateAndLine(LocalDate date, String line) {
      return menuRepository.getMenusByDateAndLine(date, line);
    }

    public Optional<Menu> getMenuByDateAndMealAndLine(LocalDate date, String meal, String line) {
     return menuRepository.getMenuByDateAndMealAndLine(date, meal, line);
    }

   
    


 }