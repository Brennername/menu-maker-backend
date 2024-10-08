package com.danielremsburg.MenuMakerBackend.forms.inventory.entities;
import com.danielremsburg.MenuMakerBackend.forms.inventory.entities.InventoryItem;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "inventory")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

        @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InventoryItem> inventoryItems = new HashSet<>();

    public Set<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(Set<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
    
    // Getters and setters for id, date, and notes
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
