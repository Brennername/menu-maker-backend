package com.danielremsburg.MenuMakerBackend.forms.menus.interfaces;

import java.time.LocalDate;

import com.danielremsburg.MenuMakerBackend.forms.lines.entitites.LineEntity;
import com.danielremsburg.MenuMakerBackend.forms.meals.enums.Meal;
import com.danielremsburg.MenuMakerBackend.forms.menus.entitites.MenuEntity;

public interface Menu {
    Long getId();
    LocalDate getDate();
    Meal getMeal();
    LineEntity getLine();
    
    void setDate(LocalDate date);
    void setMeal(Meal meal);
    void setLine(LineEntity line);
   
    
    static Menu create(LocalDate date, Meal meal, LineEntity line) {
      return new MenuEntity(date, meal, line);
    }


}
