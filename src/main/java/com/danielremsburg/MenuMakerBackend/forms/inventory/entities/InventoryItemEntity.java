package com.danielremsburg.MenuMakerBackend.forms.inventory.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

import com.danielremsburg.MenuMakerBackend.forms.stockitems.entitites.StockItemEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Inventory_Item")
@Data
public class InventoryItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private InventoryEntity inventory;

    @ManyToOne
    @JoinColumn(name = "stock_item_id", nullable = false)
    private StockItemEntity stockItem;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    private String uom; // unit of measure (e.g., lbs, oz, gallons)

    public InventoryItemEntity(InventoryEntity inventory, StockItemEntity stockItem, double quantity, String uom) {
        this.inventory = inventory;
        this.stockItem = stockItem;
        this.quantity = quantity;
        this.uom = uom;
    }
    
    public InventoryItemEntity(InventoryEntity inventory){
        this.inventory = inventory;
    }

}
