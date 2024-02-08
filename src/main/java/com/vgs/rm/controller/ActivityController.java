package com.vgs.rm.controller;

import com.vgs.rm.dto.ActivityDTO;
import com.vgs.rm.service.ActivityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityService service;

    @GetMapping()
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying all activities.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getFindById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying the searched activities.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody ActivityDTO activity) {
        try {
            activity.setActive(true);
            return new ResponseEntity<>(service.save(activity), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error registering activity.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity update(@Valid @RequestBody ActivityDTO activity) {
        try {
            return new ResponseEntity<>(service.update(activity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error updating activity.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        try {
            return new ResponseEntity<>("Activity removed successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error deleting activity.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
