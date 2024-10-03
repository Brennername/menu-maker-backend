package com.danielremsburg.MenuMakerBackend.forms.menus.entitites;

import com.danielremsburg.MenuMakerBackend.forms.menus.interfaces.MenuItem;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menu_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuItemEntity implements MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuEntity menu;

}
