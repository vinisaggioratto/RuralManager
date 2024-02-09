package com.vgs.rm.controller;

import com.vgs.rm.dto.RaceAnimalDTO;
import com.vgs.rm.service.RaceAnimalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/raceanimal")
@AllArgsConstructor
public class RaceAnimalController {

    private final RaceAnimalService service;

    @GetMapping()
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying all races.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getFindById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying the searched races.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody RaceAnimalDTO raceAnimal) {
        try {
            raceAnimal.setActive(true);
            return new ResponseEntity<>(service.save(raceAnimal), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error registering race.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity update(@Valid @RequestBody RaceAnimalDTO raceAnimal) {
        try {
            return new ResponseEntity<>(service.update(raceAnimal), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error updating race.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        try {
            return new ResponseEntity<>("Race removed successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error deleting race.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }


}
