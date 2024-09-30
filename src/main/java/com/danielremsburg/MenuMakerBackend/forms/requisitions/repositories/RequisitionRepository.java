// Suggested code may be subject to a license. Learn more: ~LicenseLog:1808025080.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:1882751994.
package com.danielremsburg.MenuMakerBackend.forms.requisitions.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielremsburg.MenuMakerBackend.forms.lines.entitites.LineEntity;
import com.danielremsburg.MenuMakerBackend.forms.meals.enums.Meal;
import com.danielremsburg.MenuMakerBackend.forms.requisitions.interfaces.Requisition;

@Repository
public interface RequisitionRepository extends JpaRepository<Requisition, Long> {

    // The following methods are derived queries and will be automatically implemented by Spring Data JPA
    // based on the method names.

    // Find all Requisitions by date
    List<Requisition> findAllByDate(LocalDate date);

    // Find all Requisitions by line
    List<Requisition> findAllByLine(LineEntity line);

    // Find all Requisitions by meal
    List<Requisition> findAllByMeal(Meal meal);

    static Requisition getOrCreateRequisition(LocalDate date, LineEntity line, Meal meal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrCreateRequisition'");
    }

}
