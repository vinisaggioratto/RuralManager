package com.vgs.rm.controller;

import com.vgs.rm.dto.LoginDTO;
import com.vgs.rm.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService service;

    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    @PostMapping
    public ResponseEntity login(@Valid @RequestBody LoginDTO login){
        try {
            return new ResponseEntity<>(service.validarUser(login), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Error validating login.] - Controller: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
