package com.danielremsburg.MenuMakerBackend.features.requisitions.interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.danielremsburg.MenuMakerBackend.features.requisitions.repositories.RequisitionRepository;
import com.danielremsburg.MenuMakerBackend.models.Line;
import com.danielremsburg.MenuMakerBackend.models.Meal;

public interface Requisition {
    LocalDate getDate();
    Line getLine();
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

    default Requisition getRequisitionByDateLineMeal(LocalDate date, Line line, Meal meal)
    {
        return RequisitionRepository.getOrCreateRequisition(date, line, meal);
    }
    
}
