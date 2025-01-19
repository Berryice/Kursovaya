package com.example.demo.Repositoryes;

import com.example.demo.Tables.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitsRepository extends JpaRepository<Visits, Integer> {
}
