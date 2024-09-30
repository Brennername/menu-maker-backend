// Suggested code may be subject to a license. Learn more: ~LicenseLog:4025318084.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:113576103.
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

    public Line getLineById(Long id) {
        return lineRepository.findById(id).orElse(null);
    }

    public Line createLine(Line line) {
        return lineRepository.save(line);
    }

      public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }
}
