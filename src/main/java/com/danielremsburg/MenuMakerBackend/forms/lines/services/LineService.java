package com.danielremsburg.MenuMakerBackend.forms.lines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielremsburg.MenuMakerBackend.forms.lines.interfaces.Line;
import com.danielremsburg.MenuMakerBackend.forms.lines.repositories.LineRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineService {

    @Autowired
    private LineRepository lineRepository;

    public List<Line> getAllLines() {
        List<Line> list = new ArrayList<>();
                    var lines = lineRepository.findAll();
        for (Line line : lines) {
            list.add(line);
        }
        return list;
     }
    public Line getLineByName(String name) {
        return lineRepository.findByName(name);
    }

    public Line getLineById(Long id) {

        ////What happens when we return null?
        return lineRepository.findById(id).orElse(null);
    }

    public Line createLine(Line line) {
        return lineRepository.save(line);
    }

      public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }
}
