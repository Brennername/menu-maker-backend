package com.danielremsburg.MenuMakerBackend.forms.requisitions.entitites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.danielremsburg.MenuMakerBackend.forms.lines.entitites.LineEntity;
import com.danielremsburg.MenuMakerBackend.forms.meals.enums.Meal;
import com.danielremsburg.MenuMakerBackend.forms.requisitions.interfaces.Requisition;
import com.danielremsburg.MenuMakerBackend.forms.requisitions.repositories.RequisitionRepository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "requisitions", 
       indexes = {@Index(name = "idx_requisition_date_line_meal", 
                         columnList = "date, line_id, meal_id")})
public class RequisitionEntity implements Requisition {

    public RequisitionEntity (LocalDate date, LineEntity line, Meal meal) {
        this.date = date;
        this.line = line;
        this.meal = meal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne  // Assuming a Many-to-One relationship with Line
    @JoinColumn(name = "line_id") // Adjust column name if needed
    private LineEntity line;

    @ManyToOne  // Assuming a Many-to-One relationship with Meal
    @JoinColumn(name = "meal_id") // Adjust column name if needed
    private Meal meal;

    public static Requisition create(LocalDate date, LineEntity line, Meal meal, RequisitionRepository requisitionRepository) {
        // Create a new RequisitionImpl object
        RequisitionEntity requisition = new RequisitionEntity(date, line, meal);
        // Save the requisition to the database to generate the ID
        requisition = (RequisitionEntity) requisitionRepository.save(requisition); 
        return requisition;
    }

   
}
