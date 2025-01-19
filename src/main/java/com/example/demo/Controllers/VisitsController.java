package com.example.demo.Controllers;

import com.example.demo.Tables.Visits;
import com.example.demo.Services.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visits")
public class VisitsController {

    private final VisitsService visitsService;

    @Autowired
    public VisitsController(VisitsService visitsService) {
        this.visitsService = visitsService;
    }

    // Create a new visit
    @PostMapping
    public ResponseEntity<Visits> createVisit(@RequestBody Visits visit) {
        Visits createdVisit = visitsService.createVisit(visit);
        return new ResponseEntity<>(createdVisit, HttpStatus.CREATED);
    }

    // Get all visits
    @GetMapping
    public ResponseEntity<List<Visits>> getAllVisits() {
        List<Visits> visits = visitsService.getAllVisits();
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

    // Get a visit by ID
    @GetMapping("/{id}")
    public ResponseEntity<Visits> getVisitById(@PathVariable int id) {
        Optional<Visits> visit = visitsService.getVisitById(id);
        return visit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a visit by ID
    @PutMapping("/{id}")
    public ResponseEntity<Visits> updateVisit(@PathVariable int id, @RequestBody Visits visitDetails) {
        Visits updatedVisit = visitsService.updateVisit(id, visitDetails);
        return new ResponseEntity<>(updatedVisit, HttpStatus.OK);
    }

    // Delete a visit by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable int id) {
        visitsService.deleteVisit(id);
        return ResponseEntity.noContent().build();
    }
}
