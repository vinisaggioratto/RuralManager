package com.vgs.rm.controller;

import com.vgs.rm.dto.OperationDTO;
import com.vgs.rm.service.OperationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("operation")
@CrossOrigin
public class OperationController {

    @Autowired
    private OperationService service;

    @GetMapping()
    public ResponseEntity getAll(){
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error displaying all operations] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getFindById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.getFindById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error displaying the searched operation] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody OperationDTO operation){
        try {
            operation.setActive(true);
            return new ResponseEntity<>(service.save(operation), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error registering operation] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity update(@Valid @RequestBody OperationDTO operation){
        try {
            return new ResponseEntity<>(service.update(operation), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error updating operation] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        try {
            return new ResponseEntity<>("Operation removed successfully.", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error deleting operation.] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
