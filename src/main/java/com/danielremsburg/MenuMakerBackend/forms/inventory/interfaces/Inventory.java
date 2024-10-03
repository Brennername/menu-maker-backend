package com.danielremsburg.MenuMakerBackend.forms.inventory.interfaces;

import java.sql.Date;
import java.util.Set;

public interface Inventory {

    Long getId();

    void setId(Long id);

    Date getInventoryDate();

    void setInventoryDate (Date inventoryDate);

    Set<InventoryItem> getInventoryItems();

    void setInventoryItems(Set<InventoryItem> inventoryItems);

}
