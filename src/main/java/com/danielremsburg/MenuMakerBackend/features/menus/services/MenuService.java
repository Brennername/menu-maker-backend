package com.danielremsburg.MenuMakerBackend.features.menus.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielremsburg.MenuMakerBackend.features.menus.entitites.MenuEntity;
import com.danielremsburg.MenuMakerBackend.features.menus.repositories.MenuRepository;
import com.danielremsburg.MenuMakerBackend.models.Line;
import com.danielremsburg.MenuMakerBackend.models.Meal;
import com.danielremsburg.MenuMakerBackend.models.Menu;

import jakarta.transaction.Transactional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Transactional
    public Menu get(LocalDate date, Meal meal, Line line) {
        Optional<Menu> existingMenu = menuRepository.findByDateAndMealAndLine(date, meal, line);
        return existingMenu.orElseGet(() -> {
            Menu newMenu = new MenuEntity(date, meal, line);
            menuRepository.save(newMenu);
            return newMenu;
        });
    }

    public List<Menu> getAllMenusByDate(LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllMenusByDate'");
    }

    public Menu getMenuByDateAndMealAndLine(LocalDate date, String meal, String line) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMenuByDateAndMealAndLine'");
    }

    public List<Menu> getMenusByDateAndLine(LocalDate date, String line) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMenusByDateAndLine'");
    }

   

}