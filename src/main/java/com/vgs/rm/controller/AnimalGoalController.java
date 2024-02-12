package com.vgs.rm.controller;

import com.vgs.rm.dto.AnimalGoalDTO;
import com.vgs.rm.service.AnimalGoalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("animalgoal")
public class AnimalGoalController {

    @Autowired
    private AnimalGoalService service;

    @GetMapping()
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying all goals.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getFindById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying the searched goals.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody AnimalGoalDTO animalGoal) {
        try {
            animalGoal.setActive(true);
            return new ResponseEntity<>(service.save(animalGoal), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error registering goal.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity update(@Valid @RequestBody AnimalGoalDTO animalGoal) {
        try {
            return new ResponseEntity<>(service.update(animalGoal), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error updating goal.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        try {
            return new ResponseEntity<>("Goal removed successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error deleting goal.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
