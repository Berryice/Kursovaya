package com.example.demo.Services;

import com.example.demo.Tables.Doctors;
import com.example.demo.Repositoryes.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    private final DoctorsRepository doctorRepository;

    @Autowired
    public DoctorsService(DoctorsRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Create
    public Doctors createDoctor(Doctors doctor) {
        return doctorRepository.save(doctor);
    }

    // Read all
    public List<Doctors> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Read by ID
    public Optional<Doctors> getDoctorById(int id) {
        return doctorRepository.findById(id);
    }

    // Update
    public Doctors updateDoctor(int id, Doctors doctorDetails) {
        Doctors existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        existingDoctor.setName(doctorDetails.getName());
        existingDoctor.setSpeciality(doctorDetails.getSpeciality());
        return doctorRepository.save(existingDoctor);
    }

    // Delete
    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
