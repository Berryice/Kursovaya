package com.example.demo.Controllers;

import com.example.demo.Tables.Cabinets;
import com.example.demo.Services.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cabinets")
public class CabinetController {

    private final CabinetService cabinetService;

    @Autowired
    public CabinetController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @PostMapping
    public ResponseEntity<Cabinets> createCabinet(@RequestBody Cabinets cabinet) {
        Cabinets createdCabinet = cabinetService.createCabinet(cabinet);
        return new ResponseEntity<>(createdCabinet, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Cabinets>> getAllCabinets() {
        List<Cabinets> cabinets = cabinetService.getAllCabinets();
        return new ResponseEntity<>(cabinets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cabinets> getCabinetById(@PathVariable int id) {
        Optional<Cabinets> cabinet = cabinetService.getCabinetById(id);
        return cabinet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cabinets> updateCabinet(@PathVariable int id, @RequestBody Cabinets cabinetDetails) {
        Cabinets updatedCabinet = cabinetService.updateCabinet(id, cabinetDetails);
        return new ResponseEntity<>(updatedCabinet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCabinet(@PathVariable int id) {
        cabinetService.deleteCabinet(id);
        return ResponseEntity.noContent().build();
    }
}
