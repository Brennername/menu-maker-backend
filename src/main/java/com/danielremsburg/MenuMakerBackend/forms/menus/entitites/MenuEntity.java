// Suggested code may be subject to a license. Learn more: ~LicenseLog:1560230647.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:3774520129.
package com.danielremsburg.MenuMakerBackend.forms.menus.entitites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.time.LocalDate;

import com.danielremsburg.MenuMakerBackend.forms.lines.interfaces.Line;
import com.danielremsburg.MenuMakerBackend.forms.meals.enums.Meal;
import com.danielremsburg.MenuMakerBackend.forms.menus.interfaces.Menu;
import com.danielremsburg.MenuMakerBackend.forms.menus.interfaces.MenuItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menus")
public class MenuEntity implements Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Meal meal;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Line line;
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> menuItems; 

    public MenuEntity(LocalDate date, Meal meal, Line line) {
        this.date = date;
        this.meal = meal;
        this.line = line;
        }
    }
        
          


