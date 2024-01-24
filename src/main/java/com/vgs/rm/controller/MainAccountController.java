package com.vgs.rm.controller;

import com.vgs.rm.dto.MainAccountDTO;
import com.vgs.rm.service.MainAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("mainaccount")
public class MainAccountController {

    @Autowired
    private MainAccountService service;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying all accounts] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getFindById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying the searched account] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody MainAccountDTO mainAccount) {
        try {
            mainAccount.setActive(true);
            return new ResponseEntity<>(service.save(mainAccount), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error registering account] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody MainAccountDTO mainAccount) {
        try {
            return new ResponseEntity<>(service.update(mainAccount), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error updating account] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        try {
            return new ResponseEntity<>("Main account removed successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error deleting account] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
