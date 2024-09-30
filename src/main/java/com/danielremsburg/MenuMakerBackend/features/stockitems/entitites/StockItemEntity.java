package com.danielremsburg.MenuMakerBackend.features.stockitems.entitites;

import com.danielremsburg.MenuMakerBackend.models.StockArea;
import com.danielremsburg.MenuMakerBackend.models.StockItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock_items")
public class StockItemEntity implements StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Internal ID

    private String stockNumber; // Stock number in the system
    private String name;
    private StockArea area;
    private String description;
    private int quantity;

    // Constructors, getters, and setters
    // ...

}
