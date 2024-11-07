package com.danielremsburg.MenuMakerBackend.forms.stockitems.entitites;

import com.danielremsburg.MenuMakerBackend.forms.stockareas.controllers.interfaces.StockArea;
import com.danielremsburg.MenuMakerBackend.forms.stockitems.interfaces.StockItem;

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

}
