package com.danielremsburg.MenuMakerBackend.forms.lines.entitites;

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
public class LineEntity {
   private String name;

}
