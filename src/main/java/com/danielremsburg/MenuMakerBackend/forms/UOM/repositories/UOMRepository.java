package com.danielremsburg.MenuMakerBackend.forms.UOM.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danielremsburg.MenuMakerBackend.forms.UOM.interfaces.UOM;

@Repository
public interface UOMRepository extends CrudRepository<UOM, Long> {


}
