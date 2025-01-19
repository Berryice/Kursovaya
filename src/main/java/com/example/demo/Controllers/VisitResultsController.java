package com.example.demo.Controllers;

import com.example.demo.Tables.Visit_results;
import com.example.demo.Services.VisitResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visit_results")
public class VisitResultsController {

    private final VisitResultsService visitResultsService;

    @Autowired
    public VisitResultsController(VisitResultsService visitResultsService) {
        this.visitResultsService = visitResultsService;
    }

    // Create a new visit result
    @PostMapping
    public ResponseEntity<Visit_results> createVisitResult(@RequestBody Visit_results visitResult) {
        Visit_results createdVisitResult = visitResultsService.createVisitResult(visitResult);
        return new ResponseEntity<>(createdVisitResult, HttpStatus.CREATED);
    }

    // Get all visit results
    @GetMapping
    public ResponseEntity<List<Visit_results>> getAllVisitResults() {
        List<Visit_results> visitResults = visitResultsService.getAllVisitResults();
        return new ResponseEntity<>(visitResults, HttpStatus.OK);
    }

    // Get a visit result by ID
    @GetMapping("/{resultId}")
    public ResponseEntity<Visit_results> getVisitResultById(@PathVariable int resultId) {
        Optional<Visit_results> visitResult = visitResultsService.getVisitResultById(resultId);
        return visitResult.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a visit result by ID
    @PutMapping("/{resultId}")
    public ResponseEntity<Visit_results> updateVisitResult(@PathVariable int resultId, @RequestBody Visit_results visitResultDetails) {
        Visit_results updatedVisitResult = visitResultsService.updateVisitResult(resultId, visitResultDetails);
        return new ResponseEntity<>(updatedVisitResult, HttpStatus.OK);
    }

    // Delete a visit result by ID
    @DeleteMapping("/{resultId}")
    public ResponseEntity<Void> deleteVisitResult(@PathVariable int resultId) {
        visitResultsService.deleteVisitResult(resultId);
        return ResponseEntity.noContent().build();
    }
}
