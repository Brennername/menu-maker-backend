package com.danielremsburg.MenuMakerBackend.forms.requisitions.interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.danielremsburg.MenuMakerBackend.forms.lines.entitites.LineEntity;
import com.danielremsburg.MenuMakerBackend.forms.meals.enums.Meal;
import com.danielremsburg.MenuMakerBackend.forms.requisitions.repositories.RequisitionRepository;

public interface Requisition {
    LocalDate getDate();
    LineEntity getLine();
    Meal getMeal();

    // Default methods
    default String getFormattedDate() {
        return getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    default String getLineName() {
        return getLine().getName();
    }

    default String getMealName() {
        return getMeal().getName();
    }

    default boolean isWeekend() {
        LocalDate date = getDate();
        return date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7;
    }

    default Requisition getRequisitionByDateLineMeal(LocalDate date, LineEntity line, Meal meal)
    {
        return RequisitionRepository.getOrCreateRequisition(date, line, meal);
    }
    
}