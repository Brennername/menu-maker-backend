package com.danielremsburg.MenuMakerBackend.forms.menus.services;


import com.danielremsburg.MenuMakerBackend.forms.menus.entitites.MenuItemEntity;
import com.danielremsburg.MenuMakerBackend.forms.menus.interfaces.MenuItem;
import com.danielremsburg.MenuMakerBackend.forms.menus.repositories.MenuItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {
@Autowired
private MenuItemRepository menuItemRepository;
    public MenuItem getMenuItem(String name) {
       
       
        if (menuItemRepository.findByName(name) != null) {
            return menuItemRepository.getMenuItem(name);
        } else {
            return createMenuItem(name);
        }
    }

    private MenuItem createMenuItem(String name ) {
        MenuItemEntity entity = new MenuItemEntity();
        entity.setName(name);


        return new MenuItem() {
            @Override
            public String getName() {
                return entity.getName();
            }
        };
    }
}
