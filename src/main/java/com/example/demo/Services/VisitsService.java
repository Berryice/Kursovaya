package com.example.demo.Services;

import com.example.demo.Tables.Visits;
import com.example.demo.Repositoryes.VisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitsService {

    private final VisitsRepository visitsRepository;

    @Autowired
    public VisitsService(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    // Create
    public Visits createVisit(Visits visit) {
        return visitsRepository.save(visit);
    }

    // Read all
    public List<Visits> getAllVisits() {
        return visitsRepository.findAll();
    }

    // Read by ID
    public Optional<Visits> getVisitById(int id) {
        return visitsRepository.findById(id);
    }

    // Update
    public Visits updateVisit(int id, Visits visitDetails) {
        Visits existingVisit = visitsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visit not found"));
        existingVisit.setUser_id(visitDetails.getUser_id());
        existingVisit.setFrom_id(visitDetails.getFrom_id());
        existingVisit.setTo_id(visitDetails.getTo_id());
        existingVisit.setReasons(visitDetails.getReasons());
        existingVisit.setDate_time(visitDetails.getDate_time());
        return visitsRepository.save(existingVisit);
    }

    // Delete
    public void deleteVisit(int id) {
        visitsRepository.deleteById(id);
    }
}
