package com.vgs.rm.controller;

import com.vgs.rm.dto.RegisterDTO;
import com.vgs.rm.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private RegisterService service;

    @GetMapping
    public ResponseEntity getAll(){
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("[Error displaying all records] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.getFindById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error displaying the searched record] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody RegisterDTO register){
        try{
            register.setActive(true);
            return new ResponseEntity<>(service.save(register), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("[Error registering registration] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody RegisterDTO register){
        try {
            return new ResponseEntity<>(service.update(register), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("[Error updating record] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        try {
            return new ResponseEntity<>("Register removed successfully.", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error deleting record] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
