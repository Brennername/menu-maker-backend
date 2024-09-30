package com.danielremsburg.MenuMakerBackend.forms.stockitems.interfaces;

import com.danielremsburg.MenuMakerBackend.forms.stockareas.controllers.interfaces.StockArea;

public interface StockItem {

    Long getId();

    String getStockNumber();

    String getName();

    StockArea getArea();

    String getDescription();

    int getQuantity();

    void setId(Long id);

    void setStockNumber(String stockNumber);

    void setName(String name);

    void setArea(StockArea area);

    void setDescription(String description);

    void setQuantity(int quantity);

    boolean equals(java.lang.Object o);

    int hashCode();

    java.lang.String toString();

}