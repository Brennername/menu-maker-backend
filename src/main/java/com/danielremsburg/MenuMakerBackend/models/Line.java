package com.danielremsburg.MenuMakerBackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lines")
public class Line {
   private String name;

public static Line getByName(String line) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getByName'");
}
}
