package com.example.demo.Services;

import com.example.demo.Repositoryes.*;
import com.example.demo.Tables.Cabinets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinetService {

    private final CabinetRepository cabinetRepository;

    @Autowired
    public CabinetService(CabinetRepository cabinetRepository) {
        this.cabinetRepository = cabinetRepository;
    }

    // Create
    public Cabinets createCabinet(Cabinets cabinet) {
        return cabinetRepository.save(cabinet);
    }

    // Read all
    public List<Cabinets> getAllCabinets() {
        return cabinetRepository.findAll();
    }

    // Read by ID
    public Optional<Cabinets> getCabinetById(int id) {
        return cabinetRepository.findById(id);
    }

    // Update
    public Cabinets updateCabinet(int id, Cabinets cabinetDetails) {
        Cabinets existingCabinet = cabinetRepository.findById(id).orElseThrow(() -> new RuntimeException("Cabinet not found"));
        existingCabinet.setName(cabinetDetails.getName());
        existingCabinet.setNumber(cabinetDetails.getNumber());
        return cabinetRepository.save(existingCabinet);
    }

    // Delete
    public void deleteCabinet(int id) {
        cabinetRepository.deleteById(id);
    }
}

