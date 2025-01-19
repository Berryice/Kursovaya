package com.example.demo.Tables;

import jakarta.persistence.*;

@Entity
@Table(name="doctors")
public class Doctors {
    public Doctors(int id, String name, String speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
    }
    public Doctors() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String speciality;
}
