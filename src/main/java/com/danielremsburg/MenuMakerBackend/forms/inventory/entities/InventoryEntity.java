// Suggested code may be subject to a license. Learn more: ~LicenseLog:258602031.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:4011993403.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:1462285166.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:2400470126.
package com.danielremsburg.MenuMakerBackend.forms.inventory.entities;

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

    // Getters and setters for id, date, and notes
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
