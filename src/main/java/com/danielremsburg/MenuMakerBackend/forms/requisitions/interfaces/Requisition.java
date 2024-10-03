package com.danielremsburg.MenuMakerBackend.forms.requisitions.interfaces;

import java.time.LocalDate;
import com.danielremsburg.MenuMakerBackend.forms.lines.entitites.LineEntity;
import com.danielremsburg.MenuMakerBackend.forms.lines.interfaces.Line;
import com.danielremsburg.MenuMakerBackend.forms.meals.enums.Meal;
import com.danielremsburg.MenuMakerBackend.forms.requisitions.repositories.RequisitionRepository;

public interface Requisition {
   
    Line getLine();
    Meal getMeal();

    // Default methods
  
    default String getLineName() {
        return getLine().getName();
    }

    default String getMealName() {
        return getMeal().getName();
    }
    default Requisition getRequisitionByDateLineMeal(LocalDate date, LineEntity line, Meal meal)
    {
        return RequisitionRepository.getOrCreateRequisition(date, line, meal);
    }
    
}
