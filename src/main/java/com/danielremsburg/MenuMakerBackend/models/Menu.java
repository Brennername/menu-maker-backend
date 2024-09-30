package com.danielremsburg.MenuMakerBackend.models;

import java.time.LocalDate;

import com.danielremsburg.MenuMakerBackend.features.menus.entitites.MenuEntity;

public interface Menu {
    Long getId();
    LocalDate getDate();
    Meal getMeal();
    Line getLine();
    
    void setDate(LocalDate date);
    void setMeal(Meal meal);
    void setLine(Line line);
   
    
    static Menu create(LocalDate date, Meal meal, Line line) {
      return new MenuEntity(date, meal, line);
    }


}
