package com.vgs.rm.controller;

import com.vgs.rm.dto.LoteDTO;
import com.vgs.rm.service.LoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lote")
public class LoteController {

    @Autowired
    private LoteService service;

    @GetMapping()
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying all lotes.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getFindById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying the searched lotes.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody LoteDTO lote) {
        try {
            lote.setActive(true);
            return new ResponseEntity<>(service.save(lote), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error registering lote.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity update(@Valid @RequestBody LoteDTO lote) {
        try {
            return new ResponseEntity<>(service.update(lote), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error updating lote.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        try {
            return new ResponseEntity<>("Lote removed successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error deleting lote.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
