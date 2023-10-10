package com.webthuenha.controller;

import com.webthuenha.model.Area;
import com.webthuenha.service.iService.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private IAreaService areaService;

    @GetMapping
    public ResponseEntity<List<Area>> getAllAreas() {
        List<Area> areaList = areaService.getAll();
        if (areaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(areaList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Area> addArea(@RequestBody Area area) {
        return new ResponseEntity<>(areaService.save(area), HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Area> getArea(@PathVariable int id) {
        Area currentArea = areaService.findById(id);
        if (currentArea == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentArea, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Area> editArea(@RequestBody Area area, @PathVariable int id) {
        Area currentArea = areaService.findById(id);
        if (currentArea == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentArea.setName(area.getName());

        return new ResponseEntity<>(areaService.edit(currentArea), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Area> deleteArea(@PathVariable int id) {
        if (areaService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        areaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
