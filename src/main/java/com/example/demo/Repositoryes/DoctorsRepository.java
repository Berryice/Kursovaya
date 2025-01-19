package com.example.demo.Repositoryes;

import com.example.demo.Tables.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {
}
