package com.danielremsburg.MenuMakerBackend.features.menus.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danielremsburg.MenuMakerBackend.models.Line;
import com.danielremsburg.MenuMakerBackend.models.Meal;
import com.danielremsburg.MenuMakerBackend.models.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

  



public List<Menu> getAllMenusByDate(LocalDate date);

public List<Menu> getMenusByDateAndLine(LocalDate date, String line);

public Optional<Menu> findByDateAndMealAndLine(LocalDate date, Meal meal, Line line);

public Menu getMenuByDateAndMealAndLine(LocalDate date, String meal, String line);


}