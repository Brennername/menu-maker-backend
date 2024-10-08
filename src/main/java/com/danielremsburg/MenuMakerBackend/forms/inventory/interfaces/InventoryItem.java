package com.danielremsburg.MenuMakerBackend.forms.inventory.interfaces;

import com.danielremsburg.MenuMakerBackend.forms.inventory.entities.InventoryEntity;
import com.danielremsburg.MenuMakerBackend.forms.stockitems.entitites.StockItemEntity;

public interface InventoryItem {

    Long getId();

    InventoryEntity getInventory();

    StockItemEntity getStockItem();

    double getQuantity();

    String getUom();

}
