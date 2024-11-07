package com.danielremsburg.MenuMakerBackend.forms.inventory.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

import com.danielremsburg.MenuMakerBackend.forms.UOM.interfaces.UOM;
import com.danielremsburg.MenuMakerBackend.forms.inventory.interfaces.Inventory;
import com.danielremsburg.MenuMakerBackend.forms.stockitems.interfaces.StockItem;

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
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "stock_item_id", nullable = false)
    private StockItem stockItem;

    @Column(nullable = false)
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "uom_id", nullable = false)
    private UOM uom; // unit of measure (e.g., lbs, oz, gallons)

    

    public InventoryItemEntity(Inventory inventory, StockItem stockItem, double quantity, UOM uom) {
        this.inventory = inventory;
        this.stockItem = stockItem;
        this.quantity = quantity;
        this.uom = uom;
    }

}
