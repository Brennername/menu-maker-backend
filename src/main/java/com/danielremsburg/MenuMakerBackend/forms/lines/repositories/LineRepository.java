package com.danielremsburg.MenuMakerBackend.forms.lines.repositories;

import org.springframework.data.repository.CrudRepository;

import com.danielremsburg.MenuMakerBackend.forms.lines.interfaces.Line;

public interface LineRepository extends CrudRepository<Line, Long> {

    Line findByName(String name);

}


