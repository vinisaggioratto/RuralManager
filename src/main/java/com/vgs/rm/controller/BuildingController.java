package com.vgs.rm.controller;

import com.vgs.rm.dto.BuildingDTO;
import com.vgs.rm.service.BuildingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("building")
public class BuildingController {

    @Autowired
    private BuildingService service;

    @GetMapping()
    public ResponseEntity getAll(){
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error displaying all buildings] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getFindById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying the searched building.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody BuildingDTO building) {
        try {
            building.setActive(true);
            return new ResponseEntity<>(service.save(building), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error registering building.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity update(@Valid @RequestBody BuildingDTO building) {
        try {
            return new ResponseEntity<>(service.update(building), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error updating building.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        try {
            return new ResponseEntity<>("Building removed successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error deleting building.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
