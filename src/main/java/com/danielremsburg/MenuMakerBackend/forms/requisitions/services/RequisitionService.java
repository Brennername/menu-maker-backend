package com.danielremsburg.MenuMakerBackend.forms.requisitions.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielremsburg.MenuMakerBackend.forms.lines.entitites.LineEntity;
import com.danielremsburg.MenuMakerBackend.forms.meals.enums.Meal;
import com.danielremsburg.MenuMakerBackend.forms.requisitions.interfaces.Requisition;
import com.danielremsburg.MenuMakerBackend.forms.requisitions.repositories.RequisitionRepository;

@Service
public class RequisitionService {

    @Autowired
    private RequisitionRepository requisitionRepository;
  
    public List<Requisition> getAllRequisitions() {
        return requisitionRepository.findAll();
    }

    public Optional<Requisition> getRequisitionById(Long id) {
        return requisitionRepository.findById(id);
    }

    public List<Requisition> getRequisitionsByDate(LocalDate date) {
        return requisitionRepository.findAllByDate(date);
    }

    public List<Requisition> getRequisitionsByLine(LineEntity line) {
        return requisitionRepository.findAllByLine(line);
    }

    public List<Requisition> getRequisitionsByMeal(Meal meal) {
        return requisitionRepository.findAllByMeal(meal);
    }
    
    public void deleteRequisition(Long id) {
        requisitionRepository.deleteById(id);
    }

   

    public static Object findByDateAndMealAndLine(LocalDate date, Meal meal, LineEntity line) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDateAndMealAndLine'");
    }
}
