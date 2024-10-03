package com.danielremsburg.MenuMakerBackend.forms.requisitions.entitites;

import com.danielremsburg.MenuMakerBackend.forms.requisitions.interfaces.Requisition;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "requisition_items")
public class RequisitionItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requisition_id")
    private Requisition requisition;
    private String name;
}
