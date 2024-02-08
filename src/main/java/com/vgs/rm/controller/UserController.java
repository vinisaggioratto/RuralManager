package com.vgs.rm.controller;

import com.vgs.rm.dto.UserDTO;
import com.vgs.rm.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying all users.] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("[Error displaying the searched user.] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody UserDTO user){
        try {
            return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
            }catch(Exception e){
            return new ResponseEntity<>("[Error registering user] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    @PutMapping
    public ResponseEntity update(@Valid @RequestBody UserDTO user){
        try {
            return new ResponseEntity<>(service.update(user), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("[Error updating user] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        try {
            return new ResponseEntity<>("User removed successfully.", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error deleting user] - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
