// Suggested code may be subject to a license. Learn more: ~LicenseLog:2666328569.
package com.danielremsburg.MenuMakerBackend.forms.menus.entitites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menu_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuEntity menu;

}