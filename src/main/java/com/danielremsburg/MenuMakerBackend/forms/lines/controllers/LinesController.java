package com.danielremsburg.MenuMakerBackend.forms.lines.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.danielremsburg.MenuMakerBackend.forms.lines.interfaces.Line;
import com.danielremsburg.MenuMakerBackend.forms.lines.repositories.LineRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lines")
public class LinesController {

    @Autowired
    LineRepository lineRepository;

    @GetMapping
    public List<Line> getLines() {
        List<Line> list = new ArrayList<>();
        var lines = lineRepository.findAll();
        for (Line line : lines) {
            list.add(line);
        }
        return list;
    }

    @PostMapping
    public Line createLine(@RequestBody Line line) {
        return lineRepository.save(line);
    }

    @PutMapping("/{id}")
    public Line updateLine(@PathVariable Long id, @RequestBody Line lineDetails) {
        Line line = lineRepository.findById(id).orElseThrow();
        line.setName(lineDetails.getName());
        return lineRepository.save(line);
    }

    @DeleteMapping("/{id}")
    public void deleteLine(@PathVariable Long id) {
        lineRepository.deleteById(id);
    }
    
}
