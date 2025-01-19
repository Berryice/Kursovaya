package com.example.demo.Services;

import com.example.demo.Repositoryes.Visit_resultsRepository;
import com.example.demo.Tables.Visit_results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitResultsService {

    private final Visit_resultsRepository visitResultsRepository;

    @Autowired
    public VisitResultsService(Visit_resultsRepository visitResultsRepository) {
        this.visitResultsRepository = visitResultsRepository;
    }

    // Create
    public Visit_results createVisitResult(Visit_results visitResult) {
        return visitResultsRepository.save(visitResult);
    }

    // Read all
    public List<Visit_results> getAllVisitResults() {
        return visitResultsRepository.findAll();
    }

    // Read by ID
    public Optional<Visit_results> getVisitResultById(int resultId) {
        return visitResultsRepository.findById(resultId);
    }

    // Update
    public Visit_results updateVisitResult(int resultId, Visit_results visitResultDetails) {
        Visit_results existingVisitResult = visitResultsRepository.findById(resultId)
                .orElseThrow(() -> new RuntimeException("Visit result not found"));
        existingVisitResult.setVisit_id(visitResultDetails.getVisit_id());
        existingVisitResult.setResult(visitResultDetails.getResult());
        existingVisitResult.setAddiction_file(visitResultDetails.getAddiction_file());
        return visitResultsRepository.save(existingVisitResult);
    }

    // Delete
    public void deleteVisitResult(int resultId) {
        visitResultsRepository.deleteById(resultId);
    }
}
