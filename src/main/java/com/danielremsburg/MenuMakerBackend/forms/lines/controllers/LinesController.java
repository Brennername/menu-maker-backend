package com.danielremsburg.MenuMakerBackend.forms.lines.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.danielremsburg.MenuMakerBackend.forms.lines.interfaces.Line;
import com.danielremsburg.MenuMakerBackend.forms.lines.repositories.LineRepository;

import java.util.*;

@RestController
@RequestMapping("/lines")
public class LinesController {

    @Autowired
    LineRepository lineRepository;

    @GetMapping
    public Iterable<Line> getAllLines() {
        return lineRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Line> getLineById(@PathVariable Long id) {
        Optional<Line> line = lineRepository.findById(id);
        return line.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Line> createLine(@RequestBody Line line) {
        Line createdLine = lineRepository.save(line);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Line> updateLine(@PathVariable Long id, @RequestBody Line updatedLine) {
        Optional<Line> existingLine = lineRepository.findById(id);
        if (existingLine.isPresent()) {
            updatedLine.setId(id); // Ensure ID is not changed
            Line savedLine = lineRepository.save(updatedLine);
            return ResponseEntity.ok(savedLine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLine(@PathVariable Long id) {
        lineRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
