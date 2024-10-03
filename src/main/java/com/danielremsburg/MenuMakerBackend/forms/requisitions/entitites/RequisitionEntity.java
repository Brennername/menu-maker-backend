package com.danielremsburg.MenuMakerBackend.forms.requisitions.entitites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import com.danielremsburg.MenuMakerBackend.forms.lines.interfaces.Line;
import com.danielremsburg.MenuMakerBackend.forms.meals.enums.Meal;
import com.danielremsburg.MenuMakerBackend.forms.requisitions.interfaces.Requisition;
import com.danielremsburg.MenuMakerBackend.forms.requisitions.repositories.RequisitionRepository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "requisitions", 
       indexes = {@Index(name = "idx_requisition_line_meal", 
                         columnList = "line_id, meal_id")})
public class RequisitionEntity implements Requisition {

    public RequisitionEntity (Line line, Meal meal) {
        
        this.line = line;
        this.meal = meal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  // Assuming a Many-to-One relationship with Line
    @JoinColumn(name = "line_id") // Adjust column name if needed
    private Line line;

    @ManyToOne  // Assuming a Many-to-One relationship with Meal
    @JoinColumn(name = "meal_id") // Adjust column name if needed
    private Meal meal;
    
    @OneToMany(mappedBy = "requisition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequisitionItemEntity> requisitionItems;

    public static Requisition create(Line line, Meal meal, RequisitionRepository requisitionRepository) {
        // Create a new RequisitionImpl object
        Requisition requisition = new RequisitionEntity(line, meal);
        // Save the requisition to the database to generate the ID
        requisition = requisitionRepository.save(requisition); 
        return requisition;
    }

   
}

