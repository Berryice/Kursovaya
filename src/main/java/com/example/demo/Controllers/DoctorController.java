package com.example.demo.Controllers;

import com.example.demo.Tables.Doctors;
import com.example.demo.Services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorsService doctorService;

    @Autowired
    public DoctorController(DoctorsService doctorService) {
        this.doctorService = doctorService;
    }

    // Create a new doctor
    @PostMapping
    public ResponseEntity<Doctors> createDoctor(@RequestBody Doctors doctor) {
        Doctors createdDoctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    // Get all doctors
    @GetMapping
    public ResponseEntity<List<Doctors>> getAllDoctors() {
        List<Doctors> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // Get a doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctors> getDoctorById(@PathVariable int id) {
        Optional<Doctors> doctor = doctorService.getDoctorById(id);
        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a doctor by ID
    @PutMapping("/{id}")
    public ResponseEntity<Doctors> updateDoctor(@PathVariable int id, @RequestBody Doctors doctorDetails) {
        Doctors updatedDoctor = doctorService.updateDoctor(id, doctorDetails);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }

    // Delete a doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
